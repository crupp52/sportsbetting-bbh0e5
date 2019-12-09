package com.example.sportsbetting.seed;

import com.example.sportsbetting.domain.*;
import com.example.sportsbetting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DatabaseSeeder {

    @Autowired
    BetRepository betRepository;

    @Autowired
    OutcomeRepository outcomeRepository;

    @Autowired
    OutcomeOddRepository outcomeOddRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    SportEventRepository sportEventRepository;

    @Autowired
    WagerRepository wagerRepository;

    @PostConstruct
    public void generateSeed() {
        SportEvent sportEvent = new FootballSportEvent();
        sportEvent.setTitle("Football Match - EPIC");
        sportEvent.setStartDate(LocalDateTime.of(2019, 10, 10, 20, 0));
        sportEvent.setEndDate(LocalDateTime.of(2019, 10, 10, 22, 0));

        Bet bet = new Bet();
        bet.setBetType(BetType.NUMBER_OF_SETS);
        bet.setDescription("Bet01");

        Outcome outcome = new Outcome();
        outcome.setDescription("Coutcome0");

        OutcomeOdd outcomeOdd = new OutcomeOdd();
        outcomeOdd.setValue(BigDecimal.valueOf(200));
        outcomeOdd.setValidFrom(LocalDateTime.now());
        outcomeOdd.setValidUntil(LocalDateTime.of(2019, 12, 24, 10, 30));

        outcome.addOutcomeOddToList(outcomeOdd);
        bet.addOutcomeToList(outcome);
        sportEvent.addBetToList(bet);

        outcomeOddRepository.save(outcomeOdd);
        outcomeRepository.save(outcome);
        betRepository.save(bet);
        sportEventRepository.save(sportEvent);


        sportEvent = new FootballSportEvent();
        sportEvent.setTitle("Football Match - NOOB");
        sportEvent.setStartDate(LocalDateTime.of(2019, 10, 20, 20, 0));
        sportEvent.setEndDate(LocalDateTime.of(2019, 10, 20, 22, 0));

        bet = new Bet();
        bet.setBetType(BetType.GOALS);
        bet.setDescription("Bet02");

        outcome = new Outcome();
        outcome.setDescription("Outcome1");

        outcomeOdd = new OutcomeOdd();
        outcomeOdd.setValue(BigDecimal.valueOf(150));
        outcomeOdd.setValidFrom(LocalDateTime.now());
        outcomeOdd.setValidUntil(LocalDateTime.of(2019, 11, 24, 13, 30));

        outcome.addOutcomeOddToList(outcomeOdd);
        bet.addOutcomeToList(outcome);
        sportEvent.addBetToList(bet);

        outcomeOddRepository.save(outcomeOdd);
        outcomeRepository.save(outcome);
        betRepository.save(bet);
        sportEventRepository.save(sportEvent);


        sportEvent = new TennisSportEvent();
        sportEvent.setTitle("Tennis Challenge");
        sportEvent.setStartDate(LocalDateTime.of(2019, 11, 10, 10, 0));
        sportEvent.setEndDate(LocalDateTime.of(2019, 11, 10, 15, 0));

        bet = new Bet();
        bet.setBetType(BetType.PLAYERS_SCORE);
        bet.setDescription("Bet03");

        outcome = new Outcome();
        outcome.setDescription("Outcome4");

        outcomeOdd = new OutcomeOdd();
        outcomeOdd.setValue(BigDecimal.valueOf(600));
        outcomeOdd.setValidFrom(LocalDateTime.now());
        outcomeOdd.setValidUntil(LocalDateTime.of(2019, 11, 24, 13, 30));

        outcome.addOutcomeOddToList(outcomeOdd);
        bet.addOutcomeToList(outcome);
        sportEvent.addBetToList(bet);

        outcomeOddRepository.save(outcomeOdd);
        outcomeRepository.save(outcome);
        betRepository.save(bet);
        sportEventRepository.save(sportEvent);

        Player player = new Player();
        player.setName("user");
        player.setId(44);
        player.setPassword("titkos123");
        player.setCurrency(Currency.HUF);
        player.setBalance(BigDecimal.valueOf(50000));

        playerRepository.save(player);

        createWagers();
    }

    private void createWagers() {
        List<OutcomeOdd> outcomeOdds = (List<OutcomeOdd>) outcomeOddRepository.findAll();
        List<Wager> wagers = new ArrayList<>();

        Random rand = new Random();
        Wager wager;

        for (Player player : playerRepository.findAll()) {
            for (int i = 0; i < 4; i++) {
                wager = new Wager();
                wager.setCurrency(Currency.HUF);
                wager.setAmount(BigDecimal.valueOf(rand.nextInt(5000)));
                wager.setProcessed(rand.nextBoolean());
                wager.setWin(rand.nextBoolean());

                LocalDate randomDate = createRandomDate(2018, 2019);
                wager.setTimestampCreated(randomDate.atTime(rand.nextInt(12), rand.nextInt(59)));

                wager.setPlayer(player);
                wager.setOutcomeOdd(outcomeOdds.get(rand.nextInt(outcomeOdds.size())));

                wagers.add(wager);
            }
        }

        wagerRepository.saveAll(wagers);
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
}
