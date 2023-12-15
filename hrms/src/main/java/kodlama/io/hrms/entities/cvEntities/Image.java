package kodlama.io.hrms.entities.cvEntities;

import jakarta.persistence.*;
import kodlama.io.hrms.entities.userEntities.JobSeeker;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="images")
@Data
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imageName;
    private String imageUrl;
    private String imageId;

   @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JoinColumn(name = "job_seeker_id")
   private JobSeeker jobSeeker;

    public Image(String imageName, String imageUrl, String imageId, JobSeeker jobSeeker) {
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
        this.jobSeeker = jobSeeker;
    }
}
