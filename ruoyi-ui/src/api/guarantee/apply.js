import request from '@/utils/request'

// 查询物资调用申请记录列表
export function listApply(query) {
  return request({
    url: '/guarantee/apply/list',
    method: 'get',
    params: query
  })
}

// 查询物资调用申请记录详细
export function getApply(id) {
  return request({
    url: '/guarantee/apply/' + id,
    method: 'get'
  })
}

// 新增物资调用申请记录
export function addApply(data) {
  return request({
    url: '/guarantee/apply',
    method: 'post',
    data: data
  })
}

// 修改物资调用申请记录
export function updateApply(data) {
  return request({
    url: '/guarantee/apply',
    method: 'put',
    data: data
  })
}

// 删除物资调用申请记录
export function delApply(id) {
  return request({
    url: '/guarantee/apply/' + id,
    method: 'delete'
  })
}
