import java.util.*;

public class groupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hmap = new HashMap<>();

        for(String s : strs)
        {
            char[] ch = s.toCharArray();

            Arrays.sort(ch);

            String sorted = new String(ch);

            if(!hmap.containsKey(sorted))
            {
                hmap.put(sorted, new ArrayList<>());
            }

            hmap.get(sorted).add(s);
        }

        return new ArrayList<>(hmap.values());
    }

    public static void main(String[] args)
    {
        groupAnagram obj = new groupAnagram();

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result = obj.groupAnagrams(strs);

        System.out.println(result);
    }
}