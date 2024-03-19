package com.jpa.JPAdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jpa.JPAdemo.entity.Account;
import com.jpa.JPAdemo.repositories.AccountRepository;

@Controller
public class AccountCotroller {
	
	@Autowired
	private AccountRepository accrepo;
	
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@GetMapping("/newacc")
	public String newAcc() {
		return "NewAccount.jsp";
	}
	
	@PostMapping("/addacc")
	public String addAccountData(Account a){
		accrepo.save(a);
		System.out.println(a.getAccnm()+ " | "+a.getAccno());
		return "AccAddSuccess.jsp";
	}
	
	@GetMapping("/allacc")
	public ModelAndView empReport() {
		ModelAndView mv=new ModelAndView();
		List<Account> list=accrepo.findAll();
		mv.setViewName("AccReport.jsp");
		mv.addObject("acclist", list);
		return mv;
	}
	
	@PostMapping("/searchno")
	public ModelAndView srchAcc(int accno) {
		System.out.println(accno);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AccReport.jsp");
		Account acc=accrepo.findByAccno(accno);
		System.out.println(acc.getAccnm());
		System.out.println(acc.getBalance());
		List<Account> acclist=new ArrayList<>();
		acclist.add(acc);
		mv.addObject("acclist", acclist);
		return mv;
	}
	
	@PostMapping("/searchtype")
	public ModelAndView srchByAcctype(String acctype) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AccReport.jsp");
		List<Account> acclist=accrepo.findByAcctype(acctype);
		mv.addObject("acclist", acclist);
		return mv;
	}
	
	@PostMapping("/deposit")
	public String depositeAmt(int accno,float amount) {
		Account obj=accrepo.findByAccno(accno);
		obj.setBalance(obj.getBalance()+amount);
		accrepo.save(obj);
		System.out.println("deposit successful");
		return "index.jsp";
	}
	
	@PostMapping("/withdraw")
	public String withdrawAmt(int accno, float amt) {
		Account acc=accrepo.findByAccno(accno);
		acc.setBalance(acc.getBalance()-amt);
		accrepo.save(acc);
		System.out.println("withdraw successful");
		return "index.jsp";
	}
}
