package skylight1.opengl;

import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Used by onDrawFrame
 * 
 */
public class OpenGLGeometry {
	private final int mode;

	private final int first;

	final int numberOfVerticies;

	private OpenGLGeometryBuilderImpl<?, ?> openGLGeometryBuilderImpl;

	public OpenGLGeometry(final int aMode, final int aFirst, final int aNumberOfVerticies,
			OpenGLGeometryBuilderImpl<?, ?> anOpenGLGeometryBuilderImpl) {
		mode = aMode;
		first = aFirst;
		numberOfVerticies = aNumberOfVerticies;
		openGLGeometryBuilderImpl = anOpenGLGeometryBuilderImpl;
	}

	/**
	 * Draws the geometry defined by this object. If the geometry builder is not active, and any associated texture,
	 * then the results are unpredictable.
	 */
	public void draw(GL10 aGL10) {
		aGL10.glDrawArrays(mode, first, numberOfVerticies);
	}

	/**
	 * Updates the model associated with this geometry.
	 */
	public void updateModel(FastGeometryBuilder<?, ?> aFastGeometryBuilder) {
		final IntBuffer modelCoordinatesAsBuffer = openGLGeometryBuilderImpl.modelCoordinatesAsBuffer;
		modelCoordinatesAsBuffer.position(first * FastGeometryBuilderImpl.MODEL_COORDINATES_PER_VERTEX);
		modelCoordinatesAsBuffer.put(((FastGeometryBuilderImpl<?, ?>) aFastGeometryBuilder).modelCoordinates);
	}

	/**
	 * Updates the textures associated with this geometry.
	 */
	public void updateTexture(FastGeometryBuilder<?, ?> aFastGeometryBuilder) {
		final IntBuffer textureCoordinatesAsBuffer = openGLGeometryBuilderImpl.textureCoordinatesAsBuffer;
		// TODO precalc first * FastGeometryBuilderImpl.TEXTURE_COORDINATES_PER_VERTEX... it's a small price to pay
		textureCoordinatesAsBuffer.position(first * FastGeometryBuilderImpl.TEXTURE_COORDINATES_PER_VERTEX);
		textureCoordinatesAsBuffer.put(((FastGeometryBuilderImpl<?, ?>) aFastGeometryBuilder).textureCoordinates);
	}

	/**
	 * Updates the normals associated with this geometry.
	 */
	public void updateNormals(FastGeometryBuilder<?, ?> aFastGeometryBuilder) {
		final IntBuffer normalAsBuffer = openGLGeometryBuilderImpl.normalsAsBuffer;
		normalAsBuffer.position(first * FastGeometryBuilderImpl.NORMAL_COMPONENTS_PER_VERTEX);
		normalAsBuffer.put(((FastGeometryBuilderImpl<?, ?>) aFastGeometryBuilder).normalComponents);
	}

	/**
	 * Updates the colours associated with this geometry.
	 */
	public void updateColours(FastGeometryBuilder<?, ?> aFastGeometryBuilder) {
		final IntBuffer coloursAsBuffer = openGLGeometryBuilderImpl.coloursAsBuffer;
		coloursAsBuffer.position(first * FastGeometryBuilderImpl.COLOUR_PARTS_PER_VERTEX);
		coloursAsBuffer.put(((FastGeometryBuilderImpl<?, ?>) aFastGeometryBuilder).colours);
	}
}
