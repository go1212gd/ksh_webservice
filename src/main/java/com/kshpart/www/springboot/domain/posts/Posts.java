package com.kshpart.www.springboot.domain.posts;

import com.kshpart.www.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor // 롬복,
@Entity // 테이블과 링크될 클래스를 나타냄.
public class Posts extends BaseTimeEntity {
    @Id // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //이거 안 하면 2.0부터는 안 됨. 
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;
    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}

/* 실제 DB와 연결될 클래스. 혹은 Entity 클래스라고도 한다.
 이 클래스에서는 절대 setter 메소드 만들지 않는다.
 해당 필드의 값 변경이 필요하다면, 명확히 그 목적과 의도를 나타낼 수 있는 메소드 추가.

즉, 이 상황에서 setter가 없는 상황에서 값을 채워 db에 넣는 방법은,
기본적인 구조는 생성자를 통해 최종값을 채운 후, db에 삽입.
값 변경이 필요하면, 해당 이벤트에 맞는 public 메소드를 호출.

여기서는 @Builder를 통해 제공되는 빌더 클래스 사용.
*/
