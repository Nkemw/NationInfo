package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.NameAlreadyBoundException;
import javax.naming.directory.SearchControls;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Control.Controller;
import Model.NationDataModel;
import Model.SearchFilter;
import Model.SearchFilterModel;

//검색창 패널
public class PnSearch_main extends JPanel {

	Controller con;
	
	private JPanel pnSearch_Simple; //간편검색
	private JPanel search_Simps;
	private PnSearch_result pnSearch_result; //결과창 패널
	private PnMap_opened pnMap_opened; //지도 패널
	private JPanel pnSearch_Detail;
	
	public PnSearch_main() {
		this.setBounds(0, 0, 824, 461);
		this.setLayout(null);
		
		// 이미지 아이콘 불러오기
		ImageIcon imgBtSrch = new ImageIcon("./Images/search_go.png");
		ImageIcon imgBtMap = new ImageIcon("./Images/map.png");
				
		//간편검색 패널 설정
		pnSearch_Simple = new JPanel();
		pnSearch_Simple.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnSearch_Simple.setBounds(10, 10, 704, 451);
		pnSearch_Simple.setLayout(null);
		this.add(pnSearch_Simple);
		
		// 검색 창 안의 패널 - 검색 입력칸과 검색 결과가 들어있음
		search_Simps = new JPanel();
		search_Simps.setBorder(new LineBorder(new Color(0, 0, 0)));
		search_Simps.setBounds(39, 31, 530, 342);
		pnSearch_Simple.add(search_Simps);
		search_Simps.setLayout(null);
		
		//결과창 패널 추가
		pnSearch_result = new PnSearch_result();
		this.add(pnSearch_result);
		pnSearch_result.setVisible(false);
		
		//간편 검색창 텍스트 에어리어
		JTextArea txtName_sim = new JTextArea();
		txtName_sim.setBounds(127, 71, 270, 34);
		txtName_sim.setText("* \uC774\uB984 \uAE30\uC785");
		search_Simps.add(txtName_sim);
				
		//나라 검색 결과 버튼(예시)
		JButton btCountry1 = new JButton("Country");
		btCountry1.setBounds(0, 115, 530, 40);
		search_Simps.add(btCountry1);
		
		//검색버튼->국가명에 맞는 데이터를 찾아 search_result 패널에 보여주도록 하는 버튼
		JButton go_search_result_Button = new JButton("검색");
		go_search_result_Button.setBounds(396, 72, 57, 33);
		go_search_result_Button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		search_Simps.add(go_search_result_Button);
		
		//검색모드를 표기하는 라벨
		JLabel simple_mode_Label = new JLabel("국가명 검색 모드");
		simple_mode_Label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		simple_mode_Label.setBounds(155, 10, 232, 47);
		search_Simps.add(simple_mode_Label);
		
		//간편검색 오프버튼
		JButton switch_Off = new JButton("\uC0C1\uC138-off");
		switch_Off.setBounds(595, 39, 97, 40);
		pnSearch_Simple.add(switch_Off);
		pnSearch_Simple.setVisible(false);

		//맵 버튼
		JButton btMap_Closed = new JButton(new ImageIcon("./Images/mapClosed.PNG"));
		btMap_Closed.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btMap_Closed.setBounds(300, 10, 183, 436);
		this.add(btMap_Closed);

		//상세검색 패널
		pnSearch_Detail = new JPanel();
		pnSearch_Detail.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnSearch_Detail.setBounds(10, 10, 704, 451);
		this.add(pnSearch_Detail);
		pnSearch_Detail.setLayout(null);

		//상세검색 텍스트 에어리어, 텍스트 필드로 수정
		JLabel detail_mode_Label = new JLabel();
		detail_mode_Label.setBounds(250, 29, 400, 39);
		detail_mode_Label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		pnSearch_Detail.add(detail_mode_Label);
		detail_mode_Label.setText("조건 검색 모드");

		//상세검색 텍스트 필드 기후
		JTextField select_Climate = new JTextField();
		select_Climate.setBounds(100, 95, 180, 32);
		pnSearch_Detail.add(select_Climate);
		JLabel select_climate_Label=new JLabel();
		select_climate_Label.setBounds(40,95,30,30);
		select_climate_Label.setText("기후");
		pnSearch_Detail.add(select_climate_Label);
		
		//상세검색 텍스트 필드 종교
		JTextField select_Religion = new JTextField();
		select_Religion.setBounds(100, 155, 180, 32);
		pnSearch_Detail.add(select_Religion);
		JLabel select_Religion_Label=new JLabel();
		select_Religion_Label.setBounds(40,155,30,30);
		select_Religion_Label.setText("종교");
		pnSearch_Detail.add(select_Religion_Label);

		//상세검색 텍스트 필드 국가코드
		JTextField select_code = new JTextField();
		select_code.setBounds(100, 215, 180, 32);
		pnSearch_Detail.add(select_code);
		JLabel select_code_Label=new JLabel();
		select_code_Label.setBounds(20,215,50,30);
		select_code_Label.setText("국가코드");
		pnSearch_Detail.add(select_code_Label);

		//상세검색 텍스트 필드 위치
		JTextField select_location = new JTextField();
		select_location.setBounds(100, 275, 180, 32);
		pnSearch_Detail.add(select_location);
		JLabel select_location_Label=new JLabel();
		select_location_Label.setBounds(40,275,30,30);
		select_location_Label.setText("위치");
		pnSearch_Detail.add(select_location_Label);
		
		//상세검색 텍스트 필드 넓이
		JTextField select_area = new JTextField();
		select_area.setBounds(100, 335, 180, 32);
		pnSearch_Detail.add(select_area);
		JLabel select_area_Label=new JLabel();
		select_area_Label.setBounds(40,335,30,30);
		select_area_Label.setText("면적");
		pnSearch_Detail.add(select_area_Label);
		
		
		JButton detail_search_Button = new JButton("위 조건으로 검색하기");
		detail_search_Button.setBounds(40, 395, 240, 30);
		pnSearch_Detail.add(detail_search_Button);
		
		
		//상세검색 on/off 버튼
		JButton switch_On = new JButton("\uC0C1\uC138-on");
		switch_On.setBounds(595, 39, 97, 40);
		pnSearch_Detail.add(switch_On);

		//검색 결과 창(세부 검색창)
		//JTable tbCtris = new JTable();
		JTextArea tbCtris = new JTextArea();
		tbCtris.setBounds(297, 91, 374, 332);
		JScrollPane scrollPane = new JScrollPane(tbCtris);
		scrollPane.setBounds(297, 91, 374, 332);
		scrollPane.setAutoscrolls(true);
		pnSearch_Detail.add(scrollPane);
		

		//검색버튼(검색창으로 가는)
		JButton btSrch = new JButton(imgBtSrch);
		btSrch.setBounds(741, 326, 59, 58);
		this.add(btSrch);

		//열린 지도 창
		pnMap_opened = new PnMap_opened();
		pnMap_opened.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.add(pnMap_opened);
		pnMap_opened.setVisible(false);
		
		//대륙 지도 
		PnContinent pnContinent = new PnContinent();
		pnContinent.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnContinent.setBounds(0, 0, 704, 451);
		this.add(pnContinent);
		pnContinent.setLayout(null);
		pnContinent.setVisible(false);
		
		
		//지도버튼(지도 창으로 가는)
		JButton btMap = new JButton(imgBtMap);
		btMap.setBounds(741, 394, 59, 57);
		this.add(btMap);

	    // 검색 결과 창의 닫기 버튼 (여기서 선언하여 listener를 정의하여,
		// 다시 main 패널의 하위 패널을 보여줄 수 있게 함)
		JButton go_to_search_Button = new JButton("X");
		go_to_search_Button.setFont(new Font("Verdana", Font.BOLD, 15));
		go_to_search_Button.setBounds(12, 10, 30, 30);
		go_to_search_Button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		pnSearch_result.add(go_to_search_Button);
		
		go_to_search_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnSearch_result.setVisible(false);
				pnSearch_Simple.setVisible(true);
				btSrch.setVisible(true);
				btMap.setVisible(true);
			}
		});
		
		// 일반 검색 버튼
		go_search_result_Button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				con = new Controller();
				con.set_str(txtName_sim.getText());
				con.get_ColumnInfo().entrySet().stream().forEach(entry -> {
		            pnSearch_result.textArea.append("● " + entry.getKey() + "\t" + entry.getValue() + "\n");
		        });
				
			}
		});
		
		// 상세 검색 실행 버튼(detail_search_Button)
		detail_search_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbCtris.setText(null);
				con = new Controller();
				
				String[] key = {"climate", "religion", "contry_code", "location", "area"};
				ArrayList<String> value = new ArrayList<>();
				value.add(select_Climate.getText());
				value.add(select_Religion.getText());
				value.add(select_code.getText());
				value.add(select_location.getText());
				value.add(select_area.getText());
				
				
				ArrayList<String> result = con.detail_search(key, value);
				for(int i = 0; i < result.size(); i++) {
					tbCtris.append("● " + result.get(i) + "\n");
				}
			}
		});
		
		// 지도 창으로 가는 버튼의 반응 정의
		btMap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnMap_opened.setVisible(true);
				btMap_Closed.setVisible(false);
				pnSearch_Simple.setVisible(false);
				pnSearch_Detail.setVisible(false);
				pnContinent.setVisible(false);
			}
		});

		btMap_Closed.setVisible(true);
		pnMap_opened.setVisible(false);
		pnSearch_Detail.setVisible(false);
		
		btSrch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnMap_opened.setVisible(false);
				btMap_Closed.setVisible(false);
				pnSearch_Simple.setVisible(true);
				pnSearch_Detail.setVisible(false);
				pnContinent.setVisible(false);
			}
		});
		
		// 검색 창 스위치 -> 세부 설정을 켬
		switch_Off.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnSearch_Detail.setVisible(true);
				pnSearch_Simple.setVisible(false);
			}
		});
		
		// 검색 창 스위치 -> 세부 설정을 끔
		switch_On.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnSearch_Simple.setVisible(true);
				pnSearch_Detail.setVisible(false);
			}
		});
			
		// 닫힌 지도 -> 누르면 정상적인 지도가 나옴
		btMap_Closed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btMap_Closed.setVisible(false);
				pnMap_opened.setVisible(true);
			}
		});
	
		// 검색 결과 버튼(예시) -> 누르면 검색 결과(나라 정보)가 나옴
		btCountry1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnSearch_result.setVisible(true);
				pnSearch_Simple.setVisible(false);
				btSrch.setVisible(false);
				btMap.setVisible(false);
			}
		});
		
		// 각 대륙으로 가는 버튼들
				JButton btNthAmerica = new JButton("N.America");
				btNthAmerica.setBounds(103, 165, 80, 25);
				pnMap_opened.add(btNthAmerica);
				
				JButton btSthAmerica = new JButton("S.America");
				btSthAmerica.setBounds(188, 283, 80, 25);
				pnMap_opened.add(btSthAmerica);
				
				JButton btAfrica = new JButton("Africa");
				btAfrica.setBounds(331, 220, 60, 25);
				pnMap_opened.add(btAfrica);
				
				JButton btEurope = new JButton("Europe");
				btEurope.setBounds(346, 142, 63, 25);
				pnMap_opened.add(btEurope);
				
				JButton btAsia = new JButton("Asia");
				btAsia.setBounds(479, 182, 50, 25);
				pnMap_opened.add(btAsia);
				
				JButton btOceania = new JButton("Oceania");
				btOceania.setBounds(545, 320, 67, 25);
				pnMap_opened.add(btOceania);
				
				btAfrica.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pnMap_opened.setVisible(false);
						pnContinent.setVisible(true);
						pnContinent.selectCont(0);
					}
				});
				
				btAsia.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pnMap_opened.setVisible(false);
						pnContinent.setVisible(true);
						pnContinent.selectCont(1);
					}
				});
				
				btEurope.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pnMap_opened.setVisible(false);
						pnContinent.setVisible(true);
						pnContinent.selectCont(2);
					}
				});

				btNthAmerica.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pnMap_opened.setVisible(false);
						pnContinent.setVisible(true);
						pnContinent.selectCont(3);
					}
				});
				
				btOceania.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pnMap_opened.setVisible(false);
						pnContinent.setVisible(true);
						pnContinent.selectCont(4);
					}
				});
				
				btSthAmerica.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pnMap_opened.setVisible(false);
						pnContinent.setVisible(true);
						pnContinent.selectCont(5);
					}
				});
				
				btNthAmerica.setFont(new Font("고딕", Font.PLAIN, 8));
				btSthAmerica.setFont(new Font("고딕", Font.PLAIN, 8));
				btAfrica.setFont(new Font("고딕", Font.PLAIN, 8));
				btEurope.setFont(new Font("고딕", Font.PLAIN, 8));
				btAsia.setFont(new Font("고딕", Font.PLAIN, 8));
				btOceania.setFont(new Font("고딕", Font.PLAIN, 8));

	}
}
