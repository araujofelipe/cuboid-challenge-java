package co.fullstacklabs.cuboid.challenge.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuboidDTO {
    private Long id;

    @NotNull(message = "Cuboid width can't be null.")
    private Float width = 0.0f;

    @NotNull(message = "Cuboid height can't be null.")
    private Float height = 0.0f;

    @NotNull(message = "Cuboid depth can't be null.")
    private Float depth = 0.0f;

    private Double volume;

    @NotNull(message = "Cuboid related bag can't be null.")
    private Long bagId;
    
//    public Double getVolume() {
//    	if(width != null && height != null && depth != null) {
//    		return calcVolume();
//    	}
//    	return volume;
//    }
    
    public Double getVolume() {
    	if(volume != null) {
    		return this.volume;
    	}
    	return netVolume();
    }

    public boolean isValid () {
    	if(this.volume == null) {
    		return false;
    	}
    	return this.volume == netVolume();
    }
    
    public double netVolume() {
    	width = width != null ? width : 1.0f;
    	depth = depth != null ? depth : 1.0f;
    	height = height != null ? height : 1.0f;
    	return Float.valueOf(width * height * depth).doubleValue();
	}
}
