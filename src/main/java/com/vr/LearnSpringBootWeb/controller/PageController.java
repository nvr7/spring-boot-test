package com.vr.LearnSpringBootWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vr.LearnSpringBootWeb.Service.PageService;
import com.vr.LearnSpringBootWeb.model.Book;

@Controller
public class PageController {
	
	private PageService pageService;
	
	@Autowired
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	@RequestMapping("/")
	public String BookList(Model model) {
		model.addAttribute("book", pageService.listBook());
		return "page";
	}


	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("book", new Book());
		return "page2";
	}


	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveData(Model model, Book book){
		model.addAttribute("book",pageService.saveOrUpdate(book));
		return "redirect:/";
	}


	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editData(@PathVariable Integer id, Model model){
		return "page2";
	}


	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id){
		pageService.delete(id);
		return "redirect:/";
	}

}
