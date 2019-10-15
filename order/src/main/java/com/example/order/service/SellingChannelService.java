package com.example.order.service;

import com.example.order.domain.SellingChannel;
import com.example.order.repository.SellingChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellingChannelService implements ISellingChannelService
{
    @Autowired
    SellingChannelRepository sellingChannelRepository;

    @Override
    public SellingChannel save(SellingChannel sellingChannel)
    {
        return sellingChannelRepository.save(sellingChannel);
    }

    @Override
    public Optional<SellingChannel> getById(Long id)
    {
        return sellingChannelRepository.findById(id);
    }

    @Override
    public Optional<SellingChannel> put(Long id, SellingChannel sellingChannel)
    {
        Optional<SellingChannel> sellingChannel1=sellingChannelRepository.findById(id);
        if(sellingChannel1.isPresent())
        {
            sellingChannelRepository.save(sellingChannel);
        }
        return null;
    }

    @Override
    public SellingChannel update(Long id, SellingChannel sellingChannel)
    {
        Optional<SellingChannel> sellingChannel1=sellingChannelRepository.findById(id);
        if(sellingChannel1.isPresent())
        {
            sellingChannelRepository.save(sellingChannel);
        }

        return null;
    }

//    @Override
//    public void deleteById(Long id)
//    {
//        sellingChannelRepository.deleteById(id);
//    }


}
