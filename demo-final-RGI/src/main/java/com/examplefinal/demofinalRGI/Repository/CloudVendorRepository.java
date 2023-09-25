package com.examplefinal.demofinalRGI.Repository;

import java.util.List;

import com.examplefinal.demofinalRGI.models.CloudVendor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
    List<CloudVendor> findByVendorName(String vendorName);
}
