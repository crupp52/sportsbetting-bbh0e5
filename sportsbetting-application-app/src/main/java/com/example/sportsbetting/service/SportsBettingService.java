package com.example.sportsbetting.service;

import com.example.sportsbetting.domain.*;
import com.example.sportsbetting.repository.*;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EnableJpaRepositories(basePackages = "com.example.sportsbetting.repository")
public class SportsBettingService {
    private BetRepository betRepository;
    private SportEventRepository sportEventRepository;
    private OutcomeRepository outcomeRepository;
    private OutcomeOddRepository outcomeOddRepository;
    private PlayerRepository playerRepository;
    private ResultRepository resultRepository;
    private WagerRepository wagerRepository;

    private List<Player> players;
    private List<SportEvent> sportEvents;
    private List<Wager> wagers;

    Random rnd = new Random();
    private ApplicationContext context;

    public SportsBettingService() {
        this.players = new ArrayList<>();
        this.sportEvents = new ArrayList<>();
        this.wagers = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    public List<SportEvent> getSportEvents() {
        return (List<SportEvent>) sportEventRepository.findAll();
    }

    public List<Wager> getWagers() {
        return (List<Wager>) wagerRepository.findAll();
    }

    public void Initialize() {
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
        sportEvents.add(sportEvent);

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
        sportEvents.add(sportEvent);

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
        sportEvents.add(sportEvent);

        outcomeOddRepository.save(outcomeOdd);
        outcomeRepository.save(outcome);
        betRepository.save(bet);
        sportEventRepository.save(sportEvent);
    }

    public void SavePlayer(Player player) {
        playerRepository.save(player);
    }

    public Player findPlayer() {
        return playerRepository.findById(16).get();
    }

    public List<SportEvent> findAllSportEvents() {
        return (List<SportEvent>)sportEventRepository.findAll();
    }

    public boolean saveWager(Wager wager) {
        BigDecimal tempPlayerBalance = findPlayer().getBalance();
        BigDecimal wagerAmount = wager.getAmount();

        if (tempPlayerBalance.max(wagerAmount).equals(tempPlayerBalance)) {
            findPlayer().subtractValue(wagerAmount);
            wagerRepository.save(wager);

            return true;
        }

        return false;
    }

    public List<Wager> findAllWagers() {
        return (List<Wager>) wagerRepository.findAll();
    }

    private void generateResult() {
        for (Wager wager :
                wagers) {
            if (rnd.nextInt(3) == 1) {
                wager.setWin(true);
            }
        }
    }

    public void calculateResult() {
        generateResult();
        BigDecimal winValue = BigDecimal.valueOf(0);

        for (Wager wager : wagers) {
            if (wager.isWin()) {
                winValue = winValue.add(wager.getAmount().multiply(wager.getOutcomeOdd().getValue()));
            }
        }

        Player player = findPlayer();
        player.setBalance(winValue.add(player.getBalance()));
        playerRepository.save(player);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (SportEvent sportEvent :
                sportEvents) {
            for (Bet bet :
                    sportEvent.getBets()
            ) {
                for (Outcome outcome :
                        bet.getOutcomes()) {
                    for (OutcomeOdd outcomeOdd :
                            outcome.getOutcomeOdds()) {
                        output.append(sportEvent.toString()).append(", ").append(bet.toString()).append(", ").append(outcome.toString()).append(", ").append(outcomeOdd.getDatas()).append("\n");
                    }
                }
            }
        }

        return output.toString();
    }

    public void setContext(ApplicationContext context) {
        this.context = context;

        betRepository = context.getBean(BetRepository.class);
        outcomeOddRepository = context.getBean(OutcomeOddRepository.class);
        outcomeRepository = context.getBean(OutcomeRepository.class);
        playerRepository = context.getBean(PlayerRepository.class);
        resultRepository = context.getBean(ResultRepository.class);
        sportEventRepository = context.getBean(SportEventRepository.class);
        wagerRepository = context.getBean(WagerRepository.class);
    }
}
