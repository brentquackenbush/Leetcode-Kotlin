package stringmanipulation

/**
 *
 * [929. Unique Email Addresses](https://leetcode.com/problems/unique-email-addresses/)
 * @Difficulty=Easy
 *
 * Question: Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.
 *
 * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
 * If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
 *
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.
 *
 * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
 * It is possible to use both of these rules at the same time.
 *
 * Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.
 *
 * Example 1:
 *
 * Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
 *
 */
class UniqueEmailAddresses {

    fun solution(emails: Array<String>): Int {
        val uniqueEmails = mutableSetOf<String>()

        emails.forEach { email ->
            val (localName, domainName) = email.split('@')
            val canonicalEmail = localName
                .takeWhile { it != '+' }
                .replace(".", "")
            val processedEmail = "$canonicalEmail$domainName"
            uniqueEmails.add(processedEmail)
        }

        return uniqueEmails.size
    }

    /**
     *
     * Java equivalent
     * public static int numUniqueEmails(String[] emails) {
     *         HashSet<String> uniqueEmails = new HashSet<>();
     *
     *         for (String email : emails) {
     *             String[] parts = email.split("@");
     *             String localName = parts[0];
     *             String domainName = parts[1];
     *
     *             String processedLocalName = localName.split("\\+")[0].replaceAll("\\.", "");
     *             String canonicalEmail = processedLocalName + "@" + domainName;
     *
     *             uniqueEmails.add(canonicalEmail);
     *         }
     *
     *         return uniqueEmails.size();
     *     }
     */
}
// Solution
/**
 * @Time_Complexity=O(m*n)
 * M = the length of the email, N = the number of emails in the array parameter
 */
