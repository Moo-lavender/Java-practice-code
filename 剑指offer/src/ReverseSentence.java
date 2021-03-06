/*
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
正确的句子应该是“I am a student.”。
Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
思路：双指针 用i和j
*/
public class Solution {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return new String("");
        }
        char[] ans = new char[str.length()];
        char[] ch = str.toCharArray();
        int p = 0;
        int i = ch.length - 1;
        int j = i - 1;
        while (j >= 0) {
            if(ch[j] == ' ') {
                for(int t = j + 1; t <= i; t ++) {
                    ans[p ++] = ch[t];
                }
                ans[p ++] = ' ';
                i = -- j ;
                j --;
            } else {
                j --;
            }
        }
        System.arraycopy(ch,j + 1, ans, p, i - j);
        return new String(ans);
    }
}