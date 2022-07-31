# Board
코드로 배우는 스프링 부트 웹 프로젝트 Part3 실습

</br></br></br>

# 요구사항
* 사용자는 목록에서 등록된 글, 댓글 갯수, 작성자, 생성일자를 볼 수 있어야 한다.
* 사용자는 글을 등록할 수 있어야 한다.
* 사용자는 글을 수정, 삭제할 수 있어야 한다.
* 사용자는 제목, 내용, 작성자, 제목 + 내용, 제목 + 내용 + 작성자의 키워드로 검색할 수 있어야 한다.
* 사용자는 등록된 글의 댓글을 달 수 있어야 한다.
* 사용자는 댓글을 수정, 삭제할 수 있어야 한다.

</br></br></br>

# API 규격서
| 기능 | URL | 방식 | 기능 | 파라미터 타입 | Redirect URL | 데이터 예시 |
| ------------- | --------- | ------------- | ------------- | ------------- | ------------- | -------------- |
| 목록 | /board/list | GET  | 목록/페이징/검색  | PageRequestDTO | | |
| 등록 | /board/register | GET | 입력 화면 | | | |
| 등록 | /board/register | POST | 등록 처리 | BoardDTO | /board/list | [데이터 예시](#API-규격서-데이터-예시) |
| 조회 | /board/read | GET | 조회 화면 | Long | | |
| 수정 | /board/modify | GET | 수정/삭제 기능 화면 | Long | | |
| 수정 | /board/modify | POST | 수정 처리 | BoardDTO | /board/read | [데이터 예시](#API-규격서-데이터-예시) |
| 삭제 | /board/remove | POST | 삭제 처리 | Long | /board/list | [데이터 예시](#API-규격서-데이터-예시) |
| 목록 | /replies/board/{bno} | GET | 해당 게시물 댓글 조회 | Long | | |
| 등록 | /replies/ | POST | 댓글 추가 | ReplyDTO | | [데이터 예시](#API-규격서-데이터-예시) |
| 수정 | /replies/{rno} | PUT | 댓글 수정 | replyDTO | | [데이터 예시](#API-규격서-데이터-예시) |
| 삭제 | /replies/{rno} | DELETE | 댓글 삭제 | Long | | [데이터 예시](#API-규격서-데이터-예시) |


</br></br></br>

# API 규격서 데이터 예시
* Board register POST 데이터 예시
```
{
    "register": [
        {
            "title": "testTitle",
            "content": "testContent",
            "writerName": "testName",
        }
    ]
}
```
* Board modify POST 데이터 예시
```
{
    "modify": [
        {
            "title": "modifyTitle",
            "content": "modifyContent",
        }
    ]
}
```
* Board remove POST 데이터 예시
```
{
    "remove": [
        {
            "bno": "1"
        }
    ]
}
```
* Reply register POST 데이터 예시
```
{
    "register": [
        {
            "text": "testText",
            "replyer": "testReplyer",
        }
    ]
}
```
* Reply modify POST 데이터 예시
```
{
    "modify": [
        {
            "text": "modifyText",
            "replyer": "modifyReplyer",
        }
    ]
}
```
* Reply remove POST 데이터 예시
```
{
    "remove": [
        {
            "rno": "1"
        }
    ]
}
```

</br></br></br>
# ER Diagram
![image](https://user-images.githubusercontent.com/74942574/182020826-f14f58e0-4e51-4841-8a20-e73885a9f0da.png)
