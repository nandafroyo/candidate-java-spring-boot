/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.candidateapp.candidateapp.controller;

import com.candidate.entity.Candidate;
import com.candidateapp.candidateapp.dto.SearchData;
import com.candidateapp.candidateapp.service.CandidateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author actnow
 */

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    
    @RequestMapping(method = RequestMethod.POST)
    public Candidate insert(@RequestBody Candidate candidate){
        return candidateService.insert(candidate);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Candidate> findAll(){
        return candidateService.findAll();
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
    public boolean delete(@PathVariable Long id){
        return candidateService.delete(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value ="/search")
    public List<Candidate> search(@RequestBody SearchData searchData){
        return candidateService.findByName(searchData.getSearchKey());
    }
}
