package landingpage.lm.container;

public class Manifest {
	private ImageManifest imageManifest;
	
	public Manifest(ImageManifest imageManifest)
	{
		this.imageManifest = imageManifest;
	}

	public ImageManifest getImageManifest() {
		return imageManifest;
	}

	public void setImageManifest(ImageManifest imageManifest) {
		this.imageManifest = imageManifest;
	}
}
