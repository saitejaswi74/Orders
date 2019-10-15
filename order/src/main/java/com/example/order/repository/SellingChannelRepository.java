package com.example.order.repository;

import com.example.order.domain.SellingChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellingChannelRepository extends JpaRepository<SellingChannel,Long>
{

}
