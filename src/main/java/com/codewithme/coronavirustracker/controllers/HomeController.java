package com.codewithme.coronavirustracker.controllers;

import com.codewithme.coronavirustracker.CoronaVirusDataService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@RequiredArgsConstructor
public class HomeController {
    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/") //root url
    public String home(Model model){
        //keeping things at model and access them in html
        model.addAttribute("LocationStat",coronaVirusDataService.getAllStats());
        model.addAttribute("totalReportedCases",coronaVirusDataService.getAllStats()
        .stream().mapToInt(stat->Integer.parseInt(stat.getLatestTotalCount())).sum());
        return "home";
    }
}
