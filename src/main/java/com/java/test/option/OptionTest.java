package com.java.test.option;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

@Slf4j
public class OptionTest {
	private static final Options opts = new Options();

	public static void main(String[] args) {
		CommandLineParser commandLineParser = new PosixParser();
		CommandLine commandLine = null;

		try {
			// 첫번째 p 옵션 : -p aaa (aaa 를 출력 하는 것)
			// 두번째 p 옵션 : --print aaa (aaa 를 출력 하는 것)
			// 세번째 true,false : -p 또는 --print 다음에 프린트 할 argument 를 받는다.
			opts.addOption("p", "print", true, "print input argu");
			opts.addOption("h", "help", false, "print help comment");

			commandLine = commandLineParser.parse(opts, args);

		} catch (ParseException e) {
			log.error("ParseException : ", e);
			usage();
			// 에러 발생 하였으므로 사용법을 알려줌
			return;
		}

		List list = commandLine.getArgList();

		for (int i = 0; i < list.size(); i++) {
			// argument 로 무엇을 받았는지 확인
			System.out.println("list::" + list.get(i));
		}

		// -p 나 --print 옵션이 들어오면 찍히는 곳
		if (commandLine.hasOption("p")) {
			log.info("-p 옵션으로 들어온 값을 출력 : {}", commandLine.getOptionValue("p"));
		}

		// -h 나 --help 옵션이 들어오면 실행 되는 곳
		if (commandLine.hasOption("h")) {
			usage();
		}
	}

	private static void usage() {
		HelpFormatter hf = new HelpFormatter();
		String runProgram = "java " + OptionTest.class.getName() + " [options]";
		hf.printHelp(runProgram, opts);
	}
}
