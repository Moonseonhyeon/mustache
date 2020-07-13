package com.linda.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	// 한개만 걸어두면 위험해서 두개를 함
@GetMapping({"","/"})
public String index(Model model) { //DI
	//파일이 무조건 여기에  있어야 한다. (레거시일 경우 이 위치를 설정해 줘야함)
	
String name = "cos";
int num = 10;
String password = "1234";
model.addAttribute("name", name);
model.addAttribute("num", num);
model.addAttribute("password", password);
	
	// => viewresolver/src/main/resources/templates/index.mustache
	return "Index";
}

@GetMapping("/model/data")
public String modelData(Model model) { //@Autowired안해도 여기 파라메터 에서 DI !!
	Member member = Member.builder()
			.id(1)
			.name("ssar")
			.phone("01022229999")
			.build();
	model.addAttribute(member);
	return "modelData";
}

@GetMapping("/model/array")
public String modelArray(Model model) { //@Autowired안해도 여기 파라메터 에서 DI !!
	Member member1 = Member.builder()
			.id(1)
			.name("ssar")
			.phone("01022223333")
			.build();
	Member member2 = Member.builder()
			.id(2)
			.name("cos")
			.phone("01022229999")
			.build();
	List<Member> members = new ArrayList<>();
	members.add(member1);
	members.add(member2);
	model.addAllAttributes(members);
	model.addAttribute("user", true);
	
	return "modelArray";
}

@GetMapping("layout")
public String layout() {
	return "layout";
}

}
