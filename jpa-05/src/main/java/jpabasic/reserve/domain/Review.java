package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(name = "hotel_id")
    private String hotelId;

    private int mark;

    @Column(name = "writer_name")
    private String writerName;

    private String comment;

    private LocalDateTime created;

    public Review(){}

    public Review(int reviewId, String hotelId, int mark, String writerName, String comment, LocalDateTime created) {
        this.reviewId = reviewId;
        this.hotelId = hotelId;
        this.mark = mark;
        this.writerName = writerName;
        this.comment = comment;
        this.created = created;
    }

    public int getReviewId() {
        return reviewId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public int getMark() {
        return mark;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", hotelId='" + hotelId + '\'' +
                ", mark=" + mark +
                ", writerName='" + writerName + '\'' +
                ", comment='" + comment + '\'' +
                ", created=" + created +
                '}';
    }
}
