package ladder.view;

import java.util.Scanner;

import ladder.exception.InputMachTypeException;
import ladder.message.ErrorMessage;

public class LadderInputView {

	private static final String PARTICIPATION_NAME_MESSAGE = "참여할 사람 이름을 입력하세요.(이름은 쉼표(,)로 구분하세요)";
	private static final String GAME_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.)";
	private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
	private static final String RESULT_PLAYER_MESSAGE = "결과를 보고 싶은 사람은?";
	private static final Scanner scanner = new Scanner(System.in);

	public static String inputParticipationPlayer() {
		System.out.println(PARTICIPATION_NAME_MESSAGE);
		return scanner.nextLine();
	}

	public static String inputGameResult() {
		System.out.println(GAME_RESULT_MESSAGE);
		return scanner.nextLine();
	}

	public static int inputLadderHeight() {
		System.out.println(LADDER_HEIGHT_MESSAGE);
		if (!scanner.hasNextInt()) {
			throw new InputMachTypeException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
		return Integer.parseInt(scanner.nextLine());
	}

	public static String inputResultPlayer() {
		System.out.println(RESULT_PLAYER_MESSAGE);
		return scanner.nextLine();
	}
}