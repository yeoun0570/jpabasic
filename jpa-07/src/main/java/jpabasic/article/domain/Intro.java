package jpabasic.article.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


public class Intro {
   
    private String contentType;
   
    private String content;

    protected Intro() {
    }

    public Intro(String contentType, String content) {
        this.contentType = contentType;
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Intro{" +
                "contentType='" + contentType + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
