package com.hhmedic.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lcssos on 2017/7/17.
 */
@Controller
@RequestMapping("/slide_dzi")
public class SlidedziController {

	@GetMapping(value = "/{id}", produces = { "application/xml;charset=UTF-8" })
	@ResponseBody
	public String detail(@PathVariable String id){

		//60483, 110059		16
		//30241, 55029		15
		//15120, 27514		14
		//7560, 13757		13
		//3780, 6878		12
		//1890, 3439		11
		//945, 1719			10
		//472, 859			9
		//236, 429			8
		//118, 214			7
		//59, 107			6
		//29, 53			5
		//14, 26			4
		//7, 13				3
		//3, 6				2
		//1, 2				1
		//1, 1				0

		if("v2".equals(id)){
			return "<?xml version='1.0' encoding='UTF-8'?>\n<Image Url=\"http://imgs.hh-medic.com/pathology/0/K1703243-%E5%AE%89%E7%8E%89%E9%A6%99_kfb_0/\" Format=\"jpg\" Overlap=\"1\" TileSize=\"254\" xmlns=\"http://schemas.hh-medic.com/deepzoom/2008\"><Size Height=\"60483\" Width=\"110059\" /></Image>";
		}

		return "<?xml version='1.0' encoding='UTF-8'?>\n<Image Url=\"/slide_files/\" Format=\"jpeg\" Overlap=\"1\" TileSize=\"254\" xmlns=\"http://schemas.microsoft.com/deepzoom/2008\"><Size Height=\"210579\" Width=\"94968\" /></Image>";
	}

}
