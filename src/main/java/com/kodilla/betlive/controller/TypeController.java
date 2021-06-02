package com.kodilla.betlive.controller;

import com.kodilla.betlive.domain.Betslip;
import com.kodilla.betlive.domain.BetslipDto;
import com.kodilla.betlive.domain.Type;
import com.kodilla.betlive.service.BetslipDbService;
import com.kodilla.betlive.service.TypeDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/type")
@RequiredArgsConstructor
public class TypeController {

    private final TypeDbService typeDbService;

    @RequestMapping(method = RequestMethod.POST, value = "createType", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Type createType(@RequestBody Type type) {
        Type typeTosave = type;
        Type savedType = typeDbService.save(typeTosave);
        return savedType;

    }

    @RequestMapping(method = RequestMethod.GET, value = "findType")
    public Type findType(@RequestParam int typeId) {
        return typeDbService.findById(typeId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteType")
    public void deleteType(@RequestParam int typeId) {
        typeDbService.deleteTypeByTypeId(typeId);
    }


}
