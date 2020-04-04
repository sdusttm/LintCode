import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// TODO:
public class LintCode1070 {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<List<String>>();
        accounts.add(new ArrayList<String>() {
            {
                add("John");
                add("johnsmith@mail.com");
                add("john_newyork@mail.com");
            }
        });
        accounts.add(new ArrayList<String>() {
            {
                add("John");
                add("johnsmith@mail.com");
                add("john00@mail.com");
            }
        });
        accounts.add(new ArrayList<String>() {
            {
                add("Mary");
                add("mary@mail.com");
            }
        });
        accounts.add(new ArrayList<String>() {
            {
                add("John");
                add("johnnybravo@mail.com");
            }
        });

        LintCode1070 code = new LintCode1070();

        List<List<String>> res = code.accountsMerge(accounts);
    }

    /**
     * @param accounts: List[List[str]]
     * @return: return a List[List[str]]
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // write your code here
        HashMap<String, List<String>> emalToAccMap = new HashMap<String, List<String>>();
        Union_Find uf = new Union_Find(accounts);

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            boolean emailExist = false;
            List<String> target = null;
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emalToAccMap.containsKey(email)) {
                    emailExist = true;
                    target = emalToAccMap.get(email);
                    break;
                }
            }

            if (emailExist) {
                uf.Union(target, account);
            } else {
                for (int j = 1; j < account.size(); j++) {
                    emalToAccMap.put(account.get(j), account);
                }
            }
        }

        List<List<String>> res = new ArrayList<List<String>>();

        // accounts.forEach(x -> {
        //     if (uf.Find(x) != x) {
        //         List<String> root = uf.Find(x);
        //         for (int i = 1; i < x.size(); i++) {
        //             if (!root.contains(x.get(i))) {
        //                 root.add(x.get(i));
        //             }
        //         }
        //     }
        // });

        accounts.forEach(x -> {
            if (uf.Find(x) == x) {
                res.add(x);
            }
        });

        return res;
    }

    public class Union_Find {
        public HashMap<List<String>, List<String>> parent;

        public Union_Find(List<List<String>> accounts) {
            this.parent = new HashMap<List<String>, List<String>>();
            accounts.forEach((x) -> {
                this.parent.put(x, x);
            });
        }

        public void Union(List<String> a, List<String> b) {
            List<String> rootA = Find(a);
            List<String> rootB = Find(b);
            if (rootA != rootB) {
                this.parent.put(rootB, rootA);
            }

        }

        public List<String> Find(List<String> a) {
            List<String> root = a;
            while (this.parent.get(a) != root) {
                root = this.parent.get(a);
            }

            while (this.parent.get(a) != a) {
                List<String> temp = this.parent.get(a);
                this.parent.put(a, root);
                a = temp;
            }

            return root;
        }
    }

}