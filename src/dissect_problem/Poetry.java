package dissect_problem;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Poetry {
	public static void main(String[] args){
		String[] s = {" doufxivoqpbvuwbtaoabmdezdu ipir citusd ahey ", " eteoamsgwxooscrkoeaslxlwioisneudeu elms seaj ", " oaeumade eawozejerueaoencoeoraoquajupiev os e ", "uinwijgjuojniaieseaiceosoudpulaesuqauppo a i a e ", " udahuiounjzfmtey eonaa jay yiuuaio owig i ", "oebgebiqeuae smgetud yo ysidimigtaoinmvo yex ", " yjaeuxqsgaaomdamviagurrleudouoofmuq xlco ", "uzuaoolaitniujauwvujvbrqauaxasczxooeivilkd qo o ", "aziau qvwhlapvrjexaifioroijtoutpeoxapmeu aaquza e ", " yuasehosekirauznisauky you iitbaeebupaaw nkic ", "gaaaeeqnowbiobdsujtsnjlhpj ooajeouiao o eobhe ", "aoaeeuvucsrplmtaseckfootdagezaiphndeivndhiap ybe ", "iumaiavsauwzao ovoaxzxoixhroloi iirmsefnuouald yo ", " juw icaauosaqeaoiolrdzqchsrizeaivjuh thaopide ", " onbuohg kauunuaueliouuuebtaieuaxzcrugwokeeiajcua ", " urajaabmzioehaeouqusapbiieqlauiokxivpbotuhxeejx ", " npgqhogbskarxmurqxnqzaeaoiod yvuiaiaeoo yaiseaf ", " fabcqu iiaal baagjaoy qmvptedmdosiu wo ", "oes sioxfloaquigi aiauieakjveeieiobwuuonuwqve u e ", "ykdijapufbgoetr gnkcauuzgalauhiaeixfiafhhniov ", " uioiicdvoeouiuaaxzzdiipvmaxixaqqeouaamjoiautxil ", "yeginacitduwoswrdonbkbpejjguta mdbjeioecvuueaay ", "gahkqaukseuoenleuairhcbqfienzliqeiuwifzufjumcesb ", "yheuedazroaaeioexmcuhevzeavhhficigsee uq uq ey ", " amjfeialfkeweei weahqpjajujwaxliqo hewoviap o ", " hevudeniilugorr iaequpuusqrsbaqeqc iubax diot ", "qefkaokilefivaawiumekihiemutulufzesuoaubvgoum ox ", "idoiacgbaepknipneq ecoevigmvbtvuvenaioeoit kugi ", "olmerimmlbwsajusanaaxuaiotaqaszxi agg uvgape wu ", " kokuieupnhgzioiauilrhqnutwinzrd khbige uovs ", "oqzfodouaxcwitwpiiwr muooetuebpobfdqxplzdaeqgn ya", "wledjgozudilfmaiasuiuoobidcxxciy iveoiootuoavaq ", " daxonaoujubenjcdzujivhaaekevjnuuuaoeoonf oeo u ", "trlokuijnuuzkxezxadauuddco hiiakz mi vo vhzeu ", " yaiaaacziuajgafesaieewnpilerueeipeaoacuiobzi ", "obojuueivuwpaxderwaaidouqekheoitnctma iq o o ", " utitaaeeioesawgcgiaeareuavnergojaelld lxeom a ", " ieva apaujuolpmgacucaifazcezqvixxhudaztuueoou ", " xukohoaimahafrpovwwscbgnahxtomohbvuqtsouioeeer ", " samh upocoslgisao yerxaljiraxuuoiglq u a odn ", " usiitpiawtaualrtvozuhpwiiivudpumbnug fiaawkc ", "yieaaznrilz eicz qnoijgajaae qdiqxitjeoalu un ", "ooafiemht sjgjaueiwodkpnwqlqoiounwiaceiakemeqesio ", "aiaesqi eeiuotmvxopgagrofoulsiueeuhnuwicruda se ", "djqcaamdeouuoqtowazhiqaqaaeevuuoqlieeiin npvpom ", "aqooeiaeorbruqgognnokmrpdqaleogznoguotfviikaueruw ", "ynpfqmaixqgx ekicadtoozeaxebdsiilip ne "}
				;
		System.out.println(rhymeScheme(s));
	//	System.out.println(getRhyme("dDDctor"));

	}

	public static String rhymeScheme(String[] poem){
		String ryhmeScheme = "";
		HashMap<String, Character> map = new HashMap<String, Character>();
		char code = '#';
		for(String line: poem){
			if(isBlank(line)){
				ryhmeScheme += " ";
				continue;
			}
			
			String ryhme = getRhyme(lastWord(line));// the ryhme of the last word
			if(!map.containsKey(ryhme)){
				code = nextCode(code);
				ryhmeScheme += code;
				map.put(ryhme, code);
			}else{
				ryhmeScheme += map.get(ryhme);
			}
		}
		return ryhmeScheme;
	}
	
	
	
	private static char nextCode(char code) {
		if(code == '#') return 'a';
		if((code >= 'a' && code < 'z')|| (code >= 'A' && code < 'Z')) return (char)(code+1);
		if(code == 'z') return 'A';
		return '#';
	}

	private static String lastWord(String line) {
		StringTokenizer st = new StringTokenizer(line);
		String lastWord = null;
		while(st.hasMoreTokens())
			lastWord = st.nextToken();
		return lastWord;
	}

	private static boolean isBlank(String line) {
		for(int i = 0; i < line.length(); i++){
			if(line.charAt(i) != ' ') return false;
		}
		return true;
	}

	public static String getRhyme(String s){
		int length = s.length();
		for(int i = length-1; i >= 0; i--){
			if(isVowel(s.charAt(i), s, i)){
				if(i == 0) return s.toLowerCase();
				int j = i;
				if(!isVowel(s.charAt(j-1),s, j-1)) 
					return s.substring(j).toLowerCase();
				
				else{
					while(j>0 && isVowel(s.charAt(j-1), s, j-1)){
						j--;
					}
					return s.substring(j).toLowerCase();
				}
			}
		}
		return null;
	}

	private static boolean isVowel(char c, String s, int index) {
		if(Character.isAlphabetic(c)) c = Character.toLowerCase(c);
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
			return true;
		}
		if(c == 'y'){
			return (index != 0 && index != s.length()-1);
		}
		return false;
	}
}
