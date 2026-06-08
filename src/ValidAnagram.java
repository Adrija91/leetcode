import java.util.HashMap;
class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hmap1 = new HashMap<>();
        HashMap<Character, Integer> hmap2 = new HashMap<>();
        if(s.length()!=t.length())
        {
            return false;
        }
        for(Character ch: s.toCharArray())
        {
            if(hmap1.containsKey(ch))
            {
                hmap1.put(ch,hmap1.get(ch)+1);
            }
            else
            {
                hmap1.put(ch,1);
            }
        }
        for(Character ch1: t.toCharArray())
        {
            if(hmap2.containsKey(ch1))
            {
                hmap2.put(ch1,hmap2.get(ch1)+1);
            }
            else
            {
                hmap2.put(ch1,1);
            }
        }
        if(hmap1.size()!=hmap2.size())
        {
            return false;
        }

        for(Character k:hmap1.keySet())
        {
            if(!((hmap2.containsKey(k) && (hmap1.get(k).equals(hmap2.get(k))))))
            {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {

        ValidAnagram obj = new ValidAnagram();

        String s = "anagram";
        String t = "nagaram";

        boolean result = obj.isAnagram(s, t);

        System.out.println(result);
    }
}