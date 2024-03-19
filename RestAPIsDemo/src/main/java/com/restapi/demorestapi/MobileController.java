package com.restapi.demorestapi;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demorestapi.entities.Mobile;
import com.restapi.demorestapi.services.MobileServices;

@RestController
@RequestMapping("/api")
public class MobileController {
	
	@Autowired
	MobileServices ms;
	
	@GetMapping("/mob/data/static")
	public Mobile mobDetail() {
		Mobile obj=new Mobile(72,"vivo Y20","Vivo","4G","3GB","64GB","Nebula Blue","IPS LED", 5000, "Qualcomm Snapdragon 439", 10999,4.0,"null");
		return obj;
	}
	
	
	//----------------------------------- GET OPERATION -------------------------------------------------
	
	// All Mobile data retrieve from DB 
	@GetMapping("/mob/data/all")
	public ArrayList<Mobile> showMobList(){
		
		ArrayList<Mobile> list=new ArrayList<>();
		list=ms.getMobList();
		return list;
	}
	
	// Mobile list retrieve by providing company 
	// http://localhost:8080/api/mob/search/company/vivo
	@GetMapping("/mob/search/company/{company}")
	public ArrayList<Mobile> showMobByCompany(@PathVariable String company){
		ArrayList<Mobile> list=ms.getMobileByComp(company);
		return list;
	}
	
	// Mobile data search by providing company and ram as input 
	// http://localhost:8080/api/mob/search/company/vivo/6GB
	@GetMapping("/mob/search/company/{company}/{ram}")
	public ArrayList<Mobile> showMobByCompAndRam(@PathVariable String company,@PathVariable String ram){
		ArrayList<Mobile> list=ms.getMobByCompAndRam(company,ram);
		return list;
	}
	
	// Mobile data search by providing Connectivity 
	// http://localhost:8080/api/mob/search/connectivity/4G or 5G
	@GetMapping("/mob/search/connectivity/{connectivity}")
	public ArrayList<Mobile> showMobByConnectivity(@PathVariable String connectivity){
		ArrayList<Mobile> list=ms.getMobDataByConnectivity(connectivity);
		return list;
	}
	
	// Mobile data searched by price in between particular range
	// http://localhost:8080/api/mob/search/price/15000
	@GetMapping("/mob/search/price/{price1}/{price2}")
	public ArrayList<Mobile> showMobByPriceRange(@PathVariable float price1, @PathVariable float price2){
		ArrayList<Mobile> list=ms.getMobByPriceRange(price1, price2);
		return list;
	}
	
	
	//----------------------------------- PosT OPERATION -------------------------------------------------
	
	// To insert mobile data in mobile database
	// http://localhost:8080/api/mob/add
	@PostMapping("/mob/add")
	public String addNewMob(@RequestBody Mobile m) {
		String status=ms.addMobileData(m);
		return status;
	}
	
	//----------------------------------- PUT OPERATION -------------------------------------------------
	
	//To Update the mobile data
	// http://localhost:8080/api/mob/data/update
	@PutMapping("/mob/data/update")
	public String updateMobData(@RequestBody Mobile m) {
		String status="";
		status=ms.mobDataUpdate(m);
		return status;
	}
	
	//To Update the mobile data
	// http://localhost:8080/api/mob/data/modify
	@PutMapping("/mob/data/modify")
	public String modifyMobData(@RequestBody Mobile m) {
		String status="";
		status=ms.modifyMobData(m);
		return status;
	}
	
	//--------------------------------- DELETE OPERATION --------------------------------------------------
	
	// To delete mobile from database
	// http://localhost:8080/api/mob/delete
	@DeleteMapping("/mob/delete")
	public String mobDelete(@RequestParam String modelname) {
		String status=ms.deleteMob(modelname);
		return status;
	}
}
