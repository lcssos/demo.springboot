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

		if("v2".equals(id)){
			return "<?xml version='1.0' encoding='UTF-8'?>\n<Image Url=\"http://imgs.hh-medic.com/pathology/0/K1703243-%E5%AE%89%E7%8E%89%E9%A6%99_kfb_0/\" Format=\"jpg\" Overlap=\"0\" TileSize=\"256\" xmlns=\"http://schemas.hh-medic.com/deepzoom/2008\"><Size Height=\"60483\" Width=\"110059\" /></Image>";
		}

		return "<?xml version='1.0' encoding='UTF-8'?>\n<Image Url=\"/slide_files/\" Format=\"jpeg\" Overlap=\"1\" TileSize=\"254\" xmlns=\"http://schemas.microsoft.com/deepzoom/2008\"><Size Height=\"210579\" Width=\"94968\" /></Image>";
	}

}
