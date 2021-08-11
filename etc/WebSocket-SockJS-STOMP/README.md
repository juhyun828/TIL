# WebSocket + SockJS + STOMP

생성일: 2021년 8월 12일 오전 3:07

```text
WebSocket 통신 : HTTP 통신에서는 불가능했던, client 요청 없이도 server에서 먼저 client으로 정보 전송하는 통신이 가능하다.

SockJS : WebSocket을 지원하지 않는 브라우저에서도 사용 가능하게 해준다.

Stomp: 특정 토픽 구독자 / 특정 유저 (특정 채팅 방 안에 있는 사람들)에게만 메시지를 보낼 수 있도록 해준다.
```

# 1. WebSocket

## [WebSocket 프로토콜의 특징](https://www.youtube.com/watch?v=MPQHvwPxDUw)

1. 양방향 통신 (Full-Duplex)
    - 데이터 송수신을 동시에 처리할 수 있는 통신 방ㅂ버
    - 클라이언트와 서버가 서로에게 원할 때 데이터를 서로 주고 받을 수 있다.
    - 통상적인 HTTP 통신 (stateless)은 Client가 요청을 보내는 경우에만 Server가 응답하는 단방향 통신
2. 실시간 네트워킹 (Real Time-Networking)
    - 웹 환경에서 연속된 데이터를 빠르게 노출
    - ex) 채팅, 주식, 비디오 데이터
    - 여러 단말기에서 빠르게 데이터를 교환

## WebSocket 동작 방법 - 핸드 쉐이킹

연결 수립 과정은 HTTP 프로토콜을 사용한다.이후 WebSocket으로 upgrade 된다.

# 2. SockJS

- 모바일 크롬, IE에서도 WebSocket이 동작 가능하게 한다.

# 3. Stomp (Streaming Text Oriented Messaging Protocol)

- WebSocket은 단지 통신 프로토콜이기 때문에, 특정 user (혹은 특정 topic의 subscriber)에게만 메시지를 보내는 방법을 담당하는 프로토콜이 Stomp다.
- `Message Broker` 라는 개념이 stomp client간의 통신을 지원한다.
    - Publisher(송신자)로부터 전달받은 메시지를 Subscriber(수신자)로 전달해주는 중간 역할을 한다.
- TextOriented :  stomp는 텍스트 처리만 가능하기 때문에 메시지 (객체)를 server로 보낼 때 `JSON.stringify(newMessage));` 받을 때 `JSON.parse(data.body)`처리를 꼭 해주어야 함
- 구독이란 개념이 존재한다 : pub/sub란 메시지를 공급하는 주체와 소비하는 주체를 분리하여 제공하는 메시징 방법
    - 채팅방을 생성한다 – pub/sub 구현을 위한 Topic이 하나 생성된다.
    - 채팅방에 입장한다 – Topic을 구독한다.
    - 채팅방에서 메시지를 보내고 받는다 – 해당 Topic으로 메시지를 `발송`하거나 구독하는 (`pub`) 메시지를 `받는다` (`sub`)

