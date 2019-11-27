package com.tenmax.interview.assignment.basic.domain;

import javax.persistence.*;

/**
 * TenMax 廣告
 */
@Entity
public class Ad {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "url", column = @Column(name = "imageUrl")),
        @AttributeOverride(name = "w", column = @Column(name = "imageWidth")),
        @AttributeOverride(name = "h", column = @Column(name = "imageHeight"))
    })
    private Image imageUrl;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "url", column = @Column(name = "iconUrl")),
        @AttributeOverride(name = "w", column = @Column(name = "iconWidth")),
        @AttributeOverride(name = "h", column = @Column(name = "iconHeight"))
    })
    private Image iconUrl;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "url", column = @Column(name = "clickUrl"))
    })
    private Link clickUrl;

    public Ad() {}

    public Ad(String title, String description, Image imageUrl, Image iconUrl, Link clickUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.iconUrl = iconUrl;
        this.clickUrl = clickUrl;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Image getImageUrl() {
        return imageUrl;
    }

    public Image getIconUrl() {
        return iconUrl;
    }

    public Link getClickUrl() {
        return clickUrl;
    }

}
