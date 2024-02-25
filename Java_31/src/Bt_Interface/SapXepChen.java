package Bt_Interface;

public class SapXepChen implements SapXepInterface {

    @Override
    public void SapXepTang(double[] arr) {
        int n = arr.length;
        double key;
        int j, i;
        for (i = 0; i < n; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[i] > key) {
                arr[j + i] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

    }

    @Override
    public void SapXepGiam(double[] arr) {
        int n = arr.length;
        double key;
        int j, i;
        for (i = 0; i < n; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[i] < key) {
                arr[j + i] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

    }

}
