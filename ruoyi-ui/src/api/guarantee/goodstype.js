import request from '@/utils/request'

// 查询货物类型信息列表
export function listGoodstype(query) {
  return request({
    url: '/guarantee/goodstype/list',
    method: 'get',
    params: query
  })
}

// 查询货物类型信息详细
export function getGoodstype(id) {
  return request({
    url: '/guarantee/goodstype/' + id,
    method: 'get'
  })
}

// 新增货物类型信息
export function addGoodstype(data) {
  return request({
    url: '/guarantee/goodstype',
    method: 'post',
    data: data
  })
}

// 修改货物类型信息
export function updateGoodstype(data) {
  return request({
    url: '/guarantee/goodstype',
    method: 'put',
    data: data
  })
}

// 删除货物类型信息
export function delGoodstype(id) {
  return request({
    url: '/guarantee/goodstype/' + id,
    method: 'delete'
  })
}
