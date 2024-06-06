package io.jp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class InsertAnimated extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Array<ShapeRenderer> shapeList = new Array<ShapeRenderer>();
	private int i;
	private int tempI = 0;
	private Integer[] arr = { 830, 995, 989, 369, 679, 77, 860, 172, 914, 59, 223, 770, 518, 452, 39, 282, 478, 566,
			154, 727, 166, 643, 803, 866, 512, 99, 576, 915, 193, 322, 863, 651, 311, 920, 341, 123, 712, 607, 514, 828,
			699, 976, 625, 159, 455, 917, 930, 613, 801, 773, 725, 695, 921, 638, 522, 72, 488, 857, 665, 817, 264, 19,
			673, 30, 457, 328, 230, 806, 178, 237, 772, 469, 35, 420, 745, 685, 151, 249, 807, 382, 138, 769, 397, 413,
			775, 55, 778, 119, 229, 278, 338, 908, 73, 300, 248, 231, 615, 568, 379, 878, 207, 408, 192, 200, 596, 942,
			317, 700, 805, 37, 642, 581, 800, 293, 861, 610, 874, 87, 526, 158, 845, 240, 812, 244, 614, 88, 245, 602,
			463, 15, 84, 564, 18, 161, 76, 623, 999, 271, 402, 859, 148, 950, 115, 716, 583, 117, 436, 97, 937, 470,
			580, 297, 291, 980, 31, 765, 449, 150, 326, 676, 833, 663, 946, 898, 836, 205, 666, 839, 585, 42, 774, 86,
			155, 779, 110, 221, 202, 609, 799, 349, 7, 961, 405, 345, 107, 617, 702, 634, 561, 792, 551, 145, 184, 38,
			486, 46, 996, 255, 292, 125, 553, 47, 986, 795, 759, 23, 516, 242, 757, 557, 409, 708, 797, 506, 175, 962,
			846, 776, 22, 907, 441, 608, 542, 785, 52, 473, 499, 652, 233, 460, 650, 136, 170, 777, 227, 605, 682, 481,
			550, 922, 902, 858, 954, 144, 69, 972, 176, 190, 711, 494, 719, 577, 849, 971, 437, 456, 275, 838, 464, 377,
			984, 164, 179, 219, 531, 94, 6, 558, 782, 535, 493, 783, 537, 549, 871, 10, 738, 365, 579, 177, 945, 521,
			856, 867, 698, 8, 880, 267, 307, 969, 406, 78, 266, 268, 152, 672, 686, 835, 502, 889, 239, 590, 635, 384,
			149, 407, 40, 396, 527, 113, 574, 601, 209, 417, 977, 329, 340, 901, 714, 640, 416, 312, 632, 360, 41, 451,
			587, 199, 79, 226, 789, 335, 337, 841, 548, 533, 752, 96, 879, 129, 547, 60, 61, 343, 539, 272, 403, 43,
			562, 730, 653, 868, 661, 637, 987, 529, 241, 401, 331, 873, 48, 993, 445, 85, 955, 722, 991, 277, 495, 511,
			66, 236, 450, 296, 135, 108, 742, 916, 36, 691, 586, 304, 491, 90, 515, 352, 206, 869, 664, 906, 92, 500,
			112, 705, 336, 631, 947, 70, 204, 819, 362, 505, 582, 741, 594, 957, 611, 104, 966, 612, 34, 489, 215, 315,
			375, 767, 829, 357, 990, 185, 383, 63, 351, 815, 925, 162, 748, 897, 811, 816, 780, 196, 295, 82, 212, 334,

	};

	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1600, 900);
		createShapes();
	}

	// E tem duplicação de if e else
	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1, true);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		renderGraphics();
		batch.end();
		InsertSort();

	}

	private void renderGraphics() {
		int x = 1;
		int i = 0;
		for (ShapeRenderer shape : shapeList) {
			// ShapeRenderer shape = new ShapeRenderer(); vai estourar a memória alguma hora
			// kkkkkkkkkkkkk
			shape.begin(ShapeType.Filled);
			shape.setColor(Color.BLUE);
			shape.rect(x, 5, 1, (float) 0.5 * arr[i]); // value precisa ser o valor trocado
			shape.end();
			x += 1;
			i++;
			// desenhar cada shape
		}
	}

	// criar os shapes apenas uma vez
	// ainda tenho que melhorar isso
	private void createShapes() {
		int x = 2;
		for (Integer value : arr) {
			ShapeRenderer shape = new ShapeRenderer();
			shape.begin(ShapeType.Filled);
			shape.setColor(Color.BLUE);
			shape.rect(x, 5, 2, (float) 0.5 * value);
			shape.end();
			shapeList.add(shape);
			x += 2;
		}
	}

	private void InsertSort() {
		if (!(i >= arr.length - 1)) {
			if (arr[tempI + 1] < arr[tempI]) {
				int tempValue = arr[tempI];
				arr[tempI] = arr[tempI + 1];
				arr[tempI + 1] = tempValue;
			} else {
				// aqui entra quando o anterior é menor
				// então atrás não vai ter menor né
				i++;
				tempI = i;
				return;
			}
			if (tempI < 1) {
				// aqui a posição já está no 0
				i++;
				tempI = i;
			} else {
				tempI--;
			}
		}
	}

	@Override
	public void dispose() {
		batch.dispose();

	}

}
