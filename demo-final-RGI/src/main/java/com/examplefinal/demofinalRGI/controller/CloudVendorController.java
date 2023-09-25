package com.examplefinal.demofinalRGI.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplefinal.demofinalRGI.Response.ResponseHandler;
import com.examplefinal.demofinalRGI.Services.CloudVendorService;
import com.examplefinal.demofinalRGI.models.CloudVendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController
{
	private static final Logger logInfo = LoggerFactory.getLogger(CloudVendorController.class);
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    // Read Specific Cloud Vendor Details from DB
    @GetMapping("/{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
       return  ResponseHandler.responseBuilder("Requested Vendor Details are given here",
                HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }

    // Read All Cloud Vendor Details from DB
    @GetMapping("/")
    public List<CloudVendor> getAllCloudVendorDetails()
    {
        logInfo.info("Fetching all Cloud Vendors");
        List<CloudVendor> vendors = cloudVendorService.getAllCloudVendors();
        logInfo.info("Fetched {} Cloud Vendors", vendors.size());
        return vendors;
    }
    
    @PostMapping("/")
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        logInfo.info("Creating Cloud Vendor: {}", cloudVendor.getVendorName());
        cloudVendorService.createCloudVendor(cloudVendor);
        logInfo.info("Cloud Vendor Created Successfully");
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping("/")
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        logInfo.info("Updating Cloud Vendor for vendorId: {}", cloudVendor.getVendorId());
        cloudVendorService.updateCloudVendor(cloudVendor);
        logInfo.info("Cloud Vendor Updated Successfully");
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        logInfo.info("Deleting Cloud Vendor for vendorId: {}", vendorId);
        cloudVendorService.deleteCloudVendor(vendorId);
        logInfo.info("Cloud Vendor Deleted Successfully");
        return "Cloud Vendor Deleted Successfully";
    }
}

