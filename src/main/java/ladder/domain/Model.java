package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.gamer.Gamers;
import ladder.message.gamer.GamerMessage;
import ladder.message.ladder.LadderSizeMessage;
import ladder.core.message.Message;
import ladder.message.result.ResultMessage;

public class Model {
    enum Step {
        GAMERS_STEP,
        LADDER_SIZE_STEP,
        RESULT_STEP;
    }
    
    private final static int GAMERS_STEP = 1;
    private Ladder ladder;
    private Gamers gamers;
    private Step step;
    
    public Model() {
        step = Step.GAMERS_STEP;
    }
    
    public void newGamers(String gamerNames) {
        gamers = Gamers.of(gamerNames);
        step = Step.LADDER_SIZE_STEP;
    }
    
    public void newLadder(int rowSize) {
        ladder = Ladder.from(rowSize, gamers.getSize());
        step = Step.RESULT_STEP;
    }

    public Message getMessage() {
        switch (step) {
            case GAMERS_STEP:
                return new GamerMessage();
            case LADDER_SIZE_STEP:
                return new LadderSizeMessage();
            case RESULT_STEP:
                return new ResultMessage(gamers, ladder);
            default:
                return new GamerMessage();
        }
    }
}