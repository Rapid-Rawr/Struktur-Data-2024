package week11;

import org.w3c.dom.Node;

// Single Linked List yang merepresentasikan penyimpanan Mahasiswa

class SistemAkademik {
    SLLMahasiswa mahasiswa = null;
    SLLKelas kelas = null;

    public static void main(String[] args) {
        SistemAkademik sa = new SistemAkademik();
        sa.runThis();
    }

    void runThis() {
        kelas = new SLLKelas();
        mahasiswa = new SLLMahasiswa();
        prosedurTambahKelas(1, "se-07-01");
        prosedurTambahKelas(2, "se-07-02");
        prosedurTambahKelas(3, "se-06-01");
        prosedurTambahKelas(4, "se-06-02");

        prosedurShowAllKelas();

        prosedurTambahMahasiswa(11, "hakim");
        prosedurTambahMahasiswa(12, "bambang");
        prosedurTambahMahasiswa(13, "bambank");
        prosedurTambahMahasiswa(14, "abdul");
        prosedurTambahMahasiswa(15, "baihaqi");
        prosedurTambahMahasiswa(16, "yantod");
        prosedurShowAllMahasiswa();

        prosedurSetKelas(11, 10);
        prosedurSetKelas(12, 2);
        prosedurSetKelas(16, 4);
        prosedurSetKelas(14, 1);
        prosedurShowAllMahasiswa();

        /*
         * 1. Lakukan penambahan kelas (prosedurTambahKelas) dengan data berikut dan
         * tentukan secara manual ID kelas
         * a. "SE-07-01"
         * b. "SE-07-02"
         * c. "SE-07-03"
         * d. "SE-07-04"
         * 2. Tambahkan data mahasiswa (ProsedurTambahMahasiswa), buat 10 mahasiswa dan
         * tentukan nim secara manual
         * 3. Petakan setiap mahasiswa kedalam kelas secara merata
         * 4. Tampilkan data seluruh kelas yang telah ditambahkan,
         * prosedurShowAllKelas()
         */
    }

    void prosedurTambahKelas(int id, String nama) {
        System.out.println("Prosedur pembuatan kelas baru " + nama);
        kelas.insert(new Kelas(id, nama));
    }

    void prosedurTambahMahasiswa(int nim, String nama) {
        System.out.println("Prosedur penerimaan mahasiswa baru baru " + nama);
        mahasiswa.insert(new Mahasiswa(nim, nama));
    }

    void prosedurShowAllMahasiswa() {
        System.out.println("Prosedur Melihat data seluruh mahasiswa");
        mahasiswa.printList();
    }

    void prosedurShowAllKelas() {
        System.out.println("Prosedur Melihat data seluruh Kelas");
        kelas.printList();
    }

    void prosedurSetKelas(int idMahasiswa, int idKelas) {
        /*
         * Algoritma
         * 1. Cari kelas yang hendak di set kepada mahasiswa, pengembalian null atau
         * NodeKelas
         * 2. Jika ketemu, lakukan set kelas kepada mahasiswa tersebut
         */
        System.out.println("Prosedur pemetakan mahasiswa ke kelas");
        int returnValue;

        NodeKelas k = kelas.search(idKelas);
        if (k != null) {
            returnValue = mahasiswa.setKelas(idMahasiswa, k);
        } else {
            System.out.println("Kelas tidak di temukan ");
            returnValue = 0;
        }

        switch (returnValue) {
            case 0:
                System.out.println("List kosong");
                break;
            case 1:
                System.out.println("Data ditemukan dan telah diset");
                break;
        }
    }

}

/*
 * Digunakan untuk menyimpan Object Mahasiswa
 */
class Mahasiswa {
    private int id;
    private String nama;
    private NodeKelas kelas;

    public Mahasiswa(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setKelas(NodeKelas kelas) {
        this.kelas = kelas;
    }

    public NodeKelas getKelas() {
        return kelas;
    }

    public String toString() {
        if (kelas == null) {
            return id + " " + nama;
        } else {
            return id + " " + nama + " " + kelas.toString();
        }
    }
}

// C. Kelas Kelas
/*
 * Digunakan untuk menyimpan Object Kelas
 */

class Kelas {
    private int id;
    private String nama;

    public Kelas(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String toString() {
        return id + " " + nama;
    }
}

/*
 * Digunakan untuk melakukan penyimpanan object kelas kedalam List Kelas
 */
class NodeKelas {
    Kelas data;
    NodeKelas next;

    NodeKelas(Kelas data) {
        this.data = data;
        next = null;
    }

    public String toString() {
        return data.toString();
    }
}

// E. Node Mahasiswa
/*
 * Digunakan untuk melakukan penyimpanan object mahasiswa kedalam List Mahasiswa
 */
class NodeMahasiswa {
    Mahasiswa data;
    NodeMahasiswa next;

    NodeMahasiswa(Mahasiswa data) {
        this.data = data;
        next = null;
    }

    public String toString() {
        return data.toString();
    }

}

// F. Single Linked List yang merepresentasikan penyimpanan Kelas
class SLLKelas {
    NodeKelas head; // head of list

    public int insert(Kelas data) {
        NodeKelas nn = new NodeKelas(data);
        NodeKelas current = head;

        if (current == null) {
            nn.next = null;
            head = nn;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }
        return 1;
    }

    public NodeKelas search(int id) {
        NodeKelas current = head;
        if (current == null) {
            return null;
        } else {
            if (current.data.getId() == id) {
                return head;
            } else {
                boolean found = false;
                while (current != null) {
                    if (current.data.getId() == id) {
                        return current;
                    }
                    current = current.next;
                }
            }
        }
        return null;
    }

    public void printList() {
        NodeKelas current = head;
        while (current != null) {
            System.out.println(current.data.toString() + " ");
            current = current.next;
        }
    }
}

// Single Linked List yang merepresentasikan penyimpanan Mahasiswa
class SLLMahasiswa {
    NodeMahasiswa head; // head of list

    public int insert(Mahasiswa data) {
        NodeMahasiswa nn = new NodeMahasiswa(data);
        NodeMahasiswa current = head;

        if (current == null) {
            nn.next = null;
            head = nn;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }
        return 1;
    }

    public NodeMahasiswa search(int id) {
        NodeMahasiswa current = head;
        if (current == null) {
            return null;
        } else {
            if (current.data.getId() == id) {
                return head;
            } else {
                while (current != null) {
                    if (current.data.getId() == id) {
                        return current;
                    }
                    current = current.next;
                }
            }
        }
        return null;
    }

    public int setKelas(int id, NodeKelas kelas) {
        NodeMahasiswa current = head;
        if (current == null) {
            return 0;
        } else {
            while (current != null) {
                if (current.data.getId() == id) {
                    current.data.setKelas(kelas);
                    System.out.println(current.data.getNama() + " dipetakan ke kelas " + kelas.toString());
                    return 1;
                }
                current = current.next;
            }
            return 0;
        }
    }

    public void printList() {
        NodeMahasiswa current = head;
        while (current != null) {
            System.out.println(current.data.toString() + " ");
            current = current.next;
        }
    }
}
