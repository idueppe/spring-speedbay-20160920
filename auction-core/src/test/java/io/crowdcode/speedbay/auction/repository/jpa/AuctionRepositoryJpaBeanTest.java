package io.crowdcode.speedbay.auction.repository.jpa;

import io.crowdcode.speedbay.auction.config.BusinessLogicAnnotationConfiguration;
import io.crowdcode.speedbay.auction.config.JpaPersistenceContextConfiguration;
import io.crowdcode.speedbay.auction.fixture.AuctionFixture;
import io.crowdcode.speedbay.auction.model.Auction;
import io.crowdcode.speedbay.auction.repository.AuctionRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        BusinessLogicAnnotationConfiguration.class,
        JpaPersistenceContextConfiguration.class})
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("jpa")
public class AuctionRepositoryJpaBeanTest {

    @Autowired
    private AuctionRepository auctionRepository;

    @PersistenceContext
    private EntityManager em;


    @Test
    @Commit
    public void a_testAuctionCreate() throws Exception {
        Auction auction = AuctionFixture.buildDefaultAuction();
        auctionRepository.save(auction);
        assertNotNull(auction.getId());
    }

    @Test
    public void b_testAuctionLoad() throws Exception {
        em.clear();
        List<Auction> all = auctionRepository.findAll();

        all.forEach((a) -> {
                    System.out.println(a);
                    a.getBids().forEach(System.out::println);
                }
        );

    }
}