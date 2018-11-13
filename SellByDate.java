package OSS_J;

interface SellByDate {
	void input(); // Scanner 이용, Vector에 제품명(name)과 유통기한(date)입력, 파일 입출력을 통한 txt파일 생성포함
	void show(); // 입력한 데이터 보여주는 함수 txt파일에 따른 구현 필요
	void delete(); // 입력되어있는 데이터에 대한 삭제함수, 파일 입출력을 통한 txt파일 삭제 포함
	void move(); // 유통기한에 따르는 정렬해주는 함수 (String date를 int형으로 변환 후 비교 후 데이터 삽입예정)
	void expiredMove(); // 유통기한 임박/만료된 제품 이동, txt파일은 유지하되 출력에 따르는 출력창 데이터 변동/출력창 재정렬 필요
	void rename(); // 이름, 유통기한 수정해주는 함수 / 수정 클릭 후 수정하려는 데이터 더블클릭 후 입력한 데이터로 최신화
				   // 수정 후 값에 따르는 txt파일을 move함수 및 show함수 연동 필요
}
