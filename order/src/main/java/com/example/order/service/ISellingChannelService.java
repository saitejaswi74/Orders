package com.example.order.service;

import com.example.order.domain.Order;
import com.example.order.domain.SellingChannel;

import java.util.Optional;

public interface ISellingChannelService
{
    SellingChannel save(SellingChannel sellingChannel);

    Optional<SellingChannel> getById(Long id);

    Optional<SellingChannel> put(Long id,SellingChannel sellingChannel);

    SellingChannel update(Long id, SellingChannel sellingChannel);
}
