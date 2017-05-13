package Skladanie;

public class Rotation {
	public int[] rot(String s, double alfa, double beta, double gamma, int[] vv){
		int i,j,k;
		double sum;
		int[] vp = new int[3];
		double cg = Math.cos(gamma);
		double sg = Math.sin(gamma);
		double[][] rotz = {{cg,sg,0},{-sg,cg,0},{0,0,1}};
		double cb = Math.cos(gamma);
		double sb= Math.sin(gamma);
		double[][] roty = {{cb,0,-sb},{0,1,0},{sb,0,cb}};
		double ca = Math.cos(gamma);
		double sa = Math.sin(gamma);
		double[][] rotx = {{1,0,0},{0,ca,sa},{0,-sa,ca}};
		
		double[][] xy = new double [3][3];
		double[][] yz = new double [3][3];
		double[][] zx = new double [3][3];
		double[][] xyz = new double [3][3];
		
		if (s=="z") {
			for (i = 0; i < 3; i++) {
				vp[i] = 0;
				for(j=0;j<3;j++)
					vp[i] = (int)(vp[i]+rotz[i][j]*vv[j]);
			}
		}
		if (s=="y") {
			for (i = 0; i < 3; i++) {
				vp[i] = 0;
				for(j=0;j<3;j++)
					vp[i] = (int)(vp[i]+roty[i][j]*vv[j]);
			}
		}
		if (s=="x") {
			for (i = 0; i < 3; i++) {
				vp[i] = 0;
				for(j=0;j<3;j++)
					vp[i] = (int)(vp[i]+rotx[i][j]*vv[j]);
			}
		}
		if (s=="xy") {
			for (i = 0; i < 3; i++) {
				
				for(j=0;j<3;j++){
					sum = 0;
					for(k=0;k<3;k++)
						sum = sum+roty[i][k]*rotx[k][j];
					xy[i][j] = sum;
				}
			}
			for(i=0;i<3;i++){
				vp[i] = 0;
				for(j=0;j<3;j++)
					vp[i] = (int)(vp[i] + xy[i][j]*vv[j]);
			}
		}
		if (s=="yz") {
			for (i = 0; i < 3; i++) {
				
				for(j=0;j<3;j++){
					sum = 0;
					for(k=0;k<3;k++)
						sum = sum+roty[i][k]*rotz[k][j];
					yz[i][j] = sum;
				}
			}
			for(i=0;i<3;i++){
				vp[i] = 0;
				for(j=0;j<3;j++)
					vp[i] = (int)(vp[i] + yz[i][j]*vv[j]);
			}
		}
		if (s=="xyz") {
			for (i = 0; i < 3; i++) {
				
				for(j=0;j<3;j++){
					sum = 0;
					for(k=0;k<3;k++)
						sum = sum+rotz[i][k]*roty[k][j];
					yz[i][j] = sum;
				}
			}
			for (i = 0; i < 3; i++) {
				
				for(j=0;j<3;j++){
					sum = 0;
					for(k=0;k<3;k++)
						sum = sum+yz[k][j]*rotx[i][k];
					xyz[i][j] = sum;
				}
			}
			for(i=0;i<3;i++){
				vp[i] = 0;
				for(j=0;j<3;j++)
					vp[i] = (int)(vp[i] + xyz[i][j]*vv[j]);
			}
		}
		return vp;
	}
}
