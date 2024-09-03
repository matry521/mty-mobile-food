import { useState,useEffect } from "react";
import { mockData } from '../../mock/list';
import {
  Form,
  Input,
  Modal,
  Button,
  Row,
  Col,
  Spin,
  message,
} from "antd";
import MyPagination, { PageInfo } from "@/components/pagination";
import { getMsg, addMsg } from "@/api";
import MyTable from "@/components/table";
import "./index.less";
import { MessageList, MapKey } from "@/types"
import list from "@/router/list";

export default function SearchPage() {
  const [form] = Form.useForm();
  const [searchForm] = Form.useForm();
  const [pageData, setPageData] = useState<PageInfo>({ page: 1 });
  const [tableData, setData] = useState<MessageList>([]);
  const [tableCol, setCol] = useState<MapKey>([]);
  const [load, setLoad] = useState(true);
  const [total, setTotal] = useState(0);
  const [showModal, setShow] = useState(false);
  //const [list, setList] = useState([]);
  // const [listData, setListData] = useState([]);

  // useEffect(() => {
  //   handlePostJSON();
  // },[])

  // useEffect(() => {
  //   if (list) {
  //     console.info(123232)
  //     setListData(list);
  //   }
  // },[list])

  // 获取列表
  const getDataList = (data: PageInfo) => {
    // console.info("listData", listData)
    getMsg(data).then((res) => {
      // const { data, status } = res;
      const {data, status } = mockData;
      if (status === 0 && data) {
        let {list, total, mapKey } = data;
      
        mapKey = mapKey.map((i) => {
          if (i.key === "description") {
            i.width = 500;
          }
          return i;
        });
       
        setCol(mapKey);
        setTotal(total);
        setData(list.map((i) => ({ ...i, key: i.m_id })));
        setLoad(false);
        return;
      }
    });
  };

  // 添加列表
  const addList = () => {
    form.validateFields().then((values) => {
      addMsg(values).then((res) => {
        if (res.status === 0) {
          form.resetFields();
          message.success(res.msg);
          setShow(false);
          search();
        }
      });
    });
  };

  // 顶部搜索
  const search = () => {
    let data = searchForm.getFieldsValue();
    setPageData({ page: 1 })
    getDataList(data);
  };

  // 页码改版
  const pageChange = (pageData: PageInfo) => {
    let data = searchForm.getFieldsValue();
    getDataList({ ...pageData, ...data });
    setPageData(pageData);
  };




  const tableTop = (
    <Row justify="space-between" gutter={80}>
     
    </Row>
  );

  const handlePostJSON = async () => {
    try {
      let body = {facilityType: 1, status: "APPROVED"}

      const response = await fetch(
        "http://localhost:8099/api/mobile/food/list",
        {
          headers: new Headers({
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json;charset=UTF-8",
          }),
          method: "POST",
          body: JSON.stringify(body)
        }
      )
      const result = await response.json();
      // setList(result.data);
    } catch(error) {
      console.error('Error fetching data:', error);
    }
    
  }

  return (
    <div className="search-container">
      <Spin spinning={load}>
        {/* <div className="top-form">
          <Form layout="inline" form={searchForm}>
            <Form.Item name="name">
              <Input placeholder="请输入状态" />
            </Form.Item>
            <Form.Item name="description">
              <Input placeholder="输入消息描述词" />
            </Form.Item>
            <Button onClick={search} type="primary" className="submit-btn">
              搜索
            </Button>
            <Button
              onClick={() => {
                searchForm.resetFields();
                search();
              }}
            >
              清空
            </Button>
          </Form>
        </div> */}
        <MyTable
          title={() => tableTop}
          dataSource={tableData}
          columns={tableCol}
          pagination={false}
          saveKey="MyListSearch"
        />
        <MyPagination
          page={pageData.page}
          immediately={getDataList}
          change={pageChange}
          total={total}
        />
      </Spin>
      <Modal
        title="添加一条记录"
        open={showModal}
        cancelText="取消"
        okText="添加"
        onOk={() => addList()}
        onCancel={() => setShow(false)}
      >
        <Form form={form}>
          <Form.Item
            label="消息名称"
            name="name"
            rules={[
              {
                required: true,
                message: "Please input your name!",
              },
            ]}
          >
            <Input />
          </Form.Item>
          <Form.Item
            label="消息描述"
            name="description"
            rules={[
              {
                required: true,
                message: "Please input your description!",
              },
              {
                min: 10,
                message: "The description must be more than 10 words!",
              },
            ]}
          >
            <Input />
          </Form.Item>
        </Form>
      </Modal>
    </div>
  );
}
SearchPage.route = {
  [MENU_PATH]: "/list/search",
};
