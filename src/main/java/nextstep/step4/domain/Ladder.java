package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

	private static final int INITIAL_POSITION = 0;

	private final Players players;
	private final Prizes prizes;
	private final List<Line> lines;

	public Ladder(Players players, Prizes prizes, List<Line> lines) {
		this.players = players;
		this.prizes = prizes;
		this.lines = new ArrayList<>(lines);
	}

	public Result play() {
		Result result = new Result();
		for (int position = INITIAL_POSITION; position < players.size(); position++) {
			result.add(players.of(position), prizes.of(destination(position)));
		}
		return result;
	}

	public List<Line> lines() {
		return Collections.unmodifiableList(lines);
	}

	private int destination(int startPosition) {
		int destination = startPosition;
		for (Line line : lines) {
			destination = line.move(destination);
		}
		return destination;
	}

}