package com.example.order.controller;


import com.example.order.domain.Order;
import com.example.order.domain.SellingChannel;
import com.example.order.service.ISellingChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sellingchannel/api/v1")
public class SellingChannelController
{
    @Autowired
    ISellingChannelService iSellingChannelService;

    @PostMapping("/save")
    SellingChannel save(@RequestBody SellingChannel sellingChannel) {
        return iSellingChannelService.save(sellingChannel);
    }

    @GetMapping("/get/{id}")
    Optional<SellingChannel> getById(@PathVariable("id") Long id) {
        return iSellingChannelService.getById(id);
    }

    @PutMapping("/put/{id}")
    Optional<SellingChannel> put(@PathVariable Long id ,@RequestBody  SellingChannel sellingChannel)
    {
        return iSellingChannelService.put(id,sellingChannel);
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SellingChannel sellingChannel)
    {
        SellingChannel sellingChannel1=iSellingChannelService.update(id,sellingChannel);
        return new ResponseEntity<>(sellingChannel1, HttpStatus.OK);
    }
}
