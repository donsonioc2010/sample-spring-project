package com.example.jong1.core.api;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatGptController {
    // OpenAiChatClient
    private final OpenAiChatModel openAiChatModel;

    // @RequestParam을 사용하여 "message"라는 이름의 요청 파라미터를 String 타입의 message 변수에 바인딩합니다.
    // 메세지가 없을시 기본 값을 "안녕하세요"으로 설정하여, 요청에서 message 파라미터가 누락된 경우 기본값을 사용합니다.
    @PostMapping("/ai/generate")
    public Map generate(@RequestBody ChatMessage chat) {
        // chatClient의 call 메소드를 호출하여 입력받은 메시지를 처리하고,
        // "generation"이라는 키와 함께 결과를 Map 객체로 래핑하여 반환합니다.
        // 이 Map 객체는 JSON 형식으로 클라이언트에게 응답됩니다.
        log.error("{}", chat.getMessage());
        return Map.of("generation", openAiChatModel.call(chat.getMessage()));
    }

    // 비동기 스트림 처리 방식

    // 반환 타입: Flux<ChatResponse>를 반환합니다.
    // Flux는 Project Reactor에서 제공하는 반응형 프로그래밍을 위한 API 중 하나로,
    // 여러 개의 데이터 아이템을 시간에 걸쳐 처리하고 반환할 때 사용합니다.
    @PostMapping("/ai/generateStream")
    public Flux<ChatResponse> generateStream(@RequestBody ChatMessage chat) {
        log.error("{}", chat.getMessage());

        Prompt prompt = new Prompt(new UserMessage(chat.getMessage()));
        log.error("Prompt.toString >>> {}", prompt.toString());
        return openAiChatModel.stream(prompt);
    }
}