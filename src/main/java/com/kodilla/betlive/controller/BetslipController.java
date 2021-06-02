package com.kodilla.betlive.controller;


import com.kodilla.betlive.domain.*;
import com.kodilla.betlive.mapper.TypeMapper;
import com.kodilla.betlive.mapper.BetslipMapper;
import com.kodilla.betlive.mapper.TicketMapper;
import com.kodilla.betlive.service.BetslipDbService;
import com.kodilla.betlive.service.TypeDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/betslip")
public class BetslipController {

    private final BetslipMapper betslipMapper;
    public final TypeMapper typeMapper;
    public final TicketMapper ticketMapper;
    private final BetslipDbService betslipDbService;
    private final TypeDbService typeDbService;

    @RequestMapping(method = RequestMethod.GET, value = "getALlTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<TypeDto> getAllTypes() {
        Set<Type> types = betslipDbService.findAllTypes(1);
        return typeMapper.maptoTypeDtoList(types);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBetslip", produces = MediaType.APPLICATION_JSON_VALUE)
    public BetslipDto getBetslip(@RequestParam int betslipId) {
        Betslip betslip =  betslipDbService.findBetslip(betslipId);
        return betslipMapper.mapToBetslipDto(betslip);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBetslip", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BetslipDto createBetslip(@RequestBody BetslipDto betslipDto) {
        Betslip betslip = betslipDbService.createBetslip(betslipMapper.mapToBetslip(betslipDto));
        return betslipMapper.mapToBetslipDto(betslip);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "saveBetslip", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BetslipDto saveBetslip(@RequestBody BetslipDto betslipDto) {
        Betslip betslip = betslipDbService.createBetslip(betslipMapper.mapToBetslip(betslipDto));
        return betslipMapper.mapToBetslipDto(betslip);

    }

    @RequestMapping(method = RequestMethod.POST, value = "addType", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addType(@RequestParam int typeId,@RequestParam int betslipId) {
        Type type = typeDbService.findById(typeId);
        betslipDbService.addType(betslipId, type);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteType")
    public void deleteType(@RequestParam int typeId,@RequestParam int betslipId) {
        Type type = typeDbService.findById(typeId);
        betslipDbService.deleteType(betslipId, type);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTicket")
    public Ticket createTicket(@RequestParam int betslipId) {
        Betslip betslip = betslipDbService.findBetslip(betslipId);
        return betslipDbService.createTicket(betslip);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBetslip")
    public void deleteBetslip(@RequestParam int betslipId) {
        betslipDbService.deleteBetslip(betslipId);
    }
}
