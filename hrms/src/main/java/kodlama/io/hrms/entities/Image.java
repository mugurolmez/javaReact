package kodlama.io.hrms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String imageUrl;
    private String imageId;

   @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JoinColumn(name = "job_seeker_id")
   private JobSeeker jobSeeker;

    public Image(String name, String imageUrl, String imageId, JobSeeker jobSeeker) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
        this.jobSeeker = jobSeeker;
    }
}
