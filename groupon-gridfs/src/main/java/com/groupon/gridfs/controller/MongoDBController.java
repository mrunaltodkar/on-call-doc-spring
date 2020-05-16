package com.groupon.gridfs.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupon.gridfs.entity.FileResource;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

@RestController
public class MongoDBController {

	@Autowired
	private GridFsOperations gridFsOperations;

	String fileID = "";

	@PostMapping("/savecoupons")
	public String saveCoupons() throws FileNotFoundException {

		DBObject metaData = new BasicDBObject();
		metaData.put("couponId", "4");
		metaData.put("couponName", "Clothing");
		metaData.put("couponDescription", "Set of six shirts");
		metaData.put("couponPrice", "2000₹");

		InputStream inputStream = new FileInputStream("S:/couponsproj/images/clothing.jpg");// Coupon image file path
		metaData.put("type", "image");
		fileID = gridFsOperations.store(inputStream, "clothing.jpg", metaData).getId().toString();

		return "SUCCESSFULLY SAVED";

	}

	@GetMapping("/coupon/{couponId}")
	public ResponseEntity retrieveSingleImageFileMetaDataUsingCouponId(@PathVariable String couponId)
			throws FileNotFoundException {

		try {
			GridFSDBFile dbFile = gridFsOperations.findOne(new Query(Criteria.where("metadata.couponId").is(couponId)));
			InputStreamResource inputStreamResource = new InputStreamResource(dbFile.getInputStream());
			System.out.println(inputStreamResource);
			return new ResponseEntity(inputStreamResource, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/allcoupons1")
	public ResponseEntity<List<InputStreamResource>> retrieveAllCoupons1() throws Exception {

		List<GridFSDBFile> dbFile = gridFsOperations.find(new Query());

		List<InputStreamResource> inputStreamResourcesList = new ArrayList<InputStreamResource>();

		for (GridFSDBFile singleFile : dbFile) {
			System.out.println(singleFile);
			InputStreamResource inputStreamResource = new InputStreamResource(singleFile.getInputStream());
			inputStreamResourcesList.add(inputStreamResource);
		}
		System.out.println(inputStreamResourcesList);

		return new ResponseEntity<List<InputStreamResource>>(inputStreamResourcesList, HttpStatus.FOUND);

	}

	@GetMapping("/allcoupons")
	public ResponseEntity<List<InputStreamResource>> retrieveAllCoupons() throws Exception {

		List<GridFSDBFile> dbFileList = gridFsOperations.find(new Query());
		List<InputStreamResource> inputStreamResourcesList = new ArrayList<InputStreamResource>();

		List<FileResource> fileResource = new ArrayList<>();

		for (GridFSDBFile singleFile : dbFileList) {
			// System.out.println(singleFile);
			FileResource fr = new FileResource(singleFile.getId().toString());
			fileResource.add(fr);
			// System.out.println(singleFile.getInputStream());

		}
		for (FileResource fileIt : fileResource) {
			GridFSDBFile dbFile = gridFsOperations.findOne(new Query(Criteria.where("_id").is(fileIt.getId())));
			System.out.println(dbFile);
			InputStreamResource inputStreamResource = new InputStreamResource(dbFile.getInputStream());
			inputStreamResourcesList.add(inputStreamResource);
		}
		System.out.println(inputStreamResourcesList);
		return new ResponseEntity<List<InputStreamResource>>(inputStreamResourcesList, HttpStatus.FOUND);

	}

	@GetMapping("/allcouponsbackup")
	public ResponseEntity<List<InputStream>> retrieveAllCouponsBackUp() throws Exception {

		List<GridFSDBFile> dbFileList = gridFsOperations.find(new Query());

		// List<FileResource> fileResource = new ArrayList<>();
		List<InputStream> fileResource = new ArrayList<>();

		for (GridFSDBFile singleFile : dbFileList) {
			// System.out.println(singleFile);

			System.out.println(singleFile.getInputStream());
			fileResource.add(singleFile.getInputStream());

		}
		System.out.println(fileResource);

		return new ResponseEntity<List<InputStream>>(fileResource, HttpStatus.FOUND);

	}
	
	
	
	@GetMapping("/save")
	public ResponseEntity<List<FileResource>> retrieveVideoFileForHomepage() throws IOException {
		List<GridFSDBFile> dbFileList = gridFsOperations.find(null);
		List<FileResource> fileResource = new ArrayList<>();
		// List<InputStreamResource> inputStreamResources = new ArrayList<>();
		// List<byte[]> byteFiles = new ArrayList<byte[]>();
		int index = 0;
		for (GridFSDBFile dbFL : dbFileList) {
			DBObject metaData = new BasicDBObject();
			metaData = dbFL.getMetaData();
			FileResource fr = new FileResource(dbFL.getId().toString(), metaData.get("title").toString(),
					metaData.get("description").toString(), metaData.get("category").toString(),
					metaData.get("userName").toString());
			fileResource.add(fr);
			// byteFiles.add(IOUtils.toByteArray(dbFL.getInputStream()));

			// inputStreamResources.add(new InputStreamResource(dbFL.getInputStream()));
		}
		// for(int i=0;i<inputStreamResources.size();i++)

		return new ResponseEntity<List<FileResource>>(fileResource, HttpStatus.OK);
	}
	
	
}
