package com.kang.community.domain;

import java.time.LocalDateTime;

public class Article {

    private Long id;
    private Long authorId;
    private Long boardId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public static class Builder {

        private Long id;
        private Long authorId;
        private Long boardId;
        private String title;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setAuthorId(Long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder setBoardId(Long boardId) {
            this.boardId = boardId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Article build() {
            return new Article(this);
        }

    }

    public Article() {
    }

    private Article(Builder builder) {
        this.id = builder.id;
        this.authorId = builder.authorId;
        this.boardId = builder.boardId;
        this.title = builder.title;
        this.content = builder.content;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public void update(Long boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
