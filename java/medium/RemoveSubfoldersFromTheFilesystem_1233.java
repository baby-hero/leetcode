package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/?envType=daily-question&envId=2024-10-25
 */
public class RemoveSubfoldersFromTheFilesystem_1233 {
    public static List<String> removeSubfolders(String[] folder) {
        List<String> results = new ArrayList<String>();
        Arrays.sort(folder);
        String preFolder = "f";
        for (String f: folder) {
            if (!f.startsWith(preFolder)) {
                results.add(f);
                preFolder = f + "/";
            }
        }
        return results;
    }

    public static void main(String[] arg) {
        String[] folders = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(removeSubfolders(folders)); // Output: ["/a","/c/d","/c/f"]
        folders = new String[]{"/a","/a/b/c","/a/b/d"};
        System.out.println(removeSubfolders(folders)); // Output: ["/a"]
        folders = new String[]{"/a/b/c","/a/b/ca","/a/b/d"};
        System.out.println(removeSubfolders(folders)); // Output: ["/a/b/c","/a/b/ca","/a/b/d"]
    }
}
